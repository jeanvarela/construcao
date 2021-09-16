package br.com.construcao.modelo.repositorio.integracao.usuario;

import br.com.modelo.entidade.usuario.Usuario;
import br.com.modelo.repositorio.usuario.UsuarioRepositorio;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

/**
 * Classe para realizar teste de integração no repositório de usuário
 *
 * @author Jean Varela
 * data    15/09/2021
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositorioTest {

    private static long idUsuario;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private static String nome  = "Usuário";
    private static String email = "usario@gmail.com";
    private static String senha = "123456";

    @Test
    @Rollback(false)
    @Order(1)
    public void adicionarUsuario_QuandoSucesso(){

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);

        Usuario usuarioPersistido = this.usuarioRepositorio.save(usuario);
        idUsuario = usuarioPersistido.getId();

        Assertions.assertThat(usuarioPersistido).isNotNull();
        Assertions.assertThat(usuarioPersistido.getId()).isGreaterThan(0);
        Assertions.assertThat(usuarioPersistido.getNome()).isEqualTo(nome);
        Assertions.assertThat(usuarioPersistido.getEmail()).isEqualTo(email);
        Assertions.assertThat(usuarioPersistido.getSenha()).isEqualTo(senha);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void pesquisaUsuarioPorIdentificador_QuandoSucesso(){
        Optional<Usuario> usuario = this.usuarioRepositorio.pesquisaUsuario(idUsuario);

        Assertions.assertThat(usuario).isPresent();
        Assertions.assertThat(usuario.get()).isNotNull();
        Assertions.assertThat(usuario.get().getId()).isEqualTo(idUsuario);
        Assertions.assertThat(usuario.get().getEmail()).isEqualTo(email);
        Assertions.assertThat(usuario.get().getNome()).isEqualTo(nome);
        Assertions.assertThat(usuario.get().getSenha()).isEqualTo(senha);
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void pesquisaUsuarioPorEmailSenha_QuandoSucesso(){
        Optional<Usuario> usuario = this.usuarioRepositorio.pesquisaUsuario(email,senha);

        Assertions.assertThat(usuario).isPresent();
        Assertions.assertThat(usuario.get()).isNotNull();
        Assertions.assertThat(usuario.get().getId()).isEqualTo(idUsuario);
        Assertions.assertThat(usuario.get().getEmail()).isEqualTo(email);
        Assertions.assertThat(usuario.get().getNome()).isEqualTo(nome);
        Assertions.assertThat(usuario.get().getSenha()).isEqualTo(senha);
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void atualizaUsuario_QuandoSucesso(){
        Optional<Usuario> usuarioOptional = this.usuarioRepositorio.pesquisaUsuario(email,senha);

        String nome  = "Usuário editado";
        String email = "usuaarioeditado@gmail.com";

        Usuario usuario = usuarioOptional.get();
        usuario.setNome(nome);
        usuario.setEmail(email);

        Usuario usuarioEditado = this.usuarioRepositorio.save(usuario);
        Assertions.assertThat(usuarioEditado).isNotNull();
        Assertions.assertThat(usuarioEditado.getId()).isEqualTo(idUsuario);
        Assertions.assertThat(usuarioEditado.getEmail()).isEqualTo(email);
        Assertions.assertThat(usuarioEditado.getNome()).isEqualTo(nome);
        Assertions.assertThat(usuarioEditado.getSenha()).isEqualTo(senha);

    }
}
