package br.com.modelo.repositorio.usuario;

import br.com.modelo.entidade.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para acessar a entidade de usuário
 *
 * @author Jean Varela
 * data    15/09/2021
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    /**
     * Recupera usuário por identificador
     *
     * @param idUsuario - Identificador do usuário
     *
     * @return Optional<Usuario> - Objeto optional com o registro do usuário
     *
     * @author Jean Varela
     * data    15/09/2021
     */
    @Query(value = "select usuario from Usuario usuario where usuario.id = :idUsuario")
    Optional<Usuario> pesquisaUsuario(@Param("idUsuario") long  idUsuario);

    /**
     * Recupera usuário por identificador
     *
     * @param email - E-mail do usuário
     * @param senha - Senha do usuário
     *
     * @return Optional<Usuario> - Objeto optional com o registro do usuário
     *
     * @author Jean Varela
     * data    15/09/2021
     */
    @Query(value = "select usuario from Usuario usuario where usuario.email = :email and usuario.senha = :senha")
    Optional<Usuario> pesquisaUsuario(@Param("email") String email, @Param("senha") String senha);

    /**
     * Recupera usuário por cpf
     *
     * @param cpf - Número do CPF
     *
     * @return Optional<Usuario> - Objeto optional com o registro do usuário
     *
     * @author Jean Varela
     * data    18/09/2021
     */
    @Query(value = "select usuario from Usuario usuario where usuario.cpf = :cpf")
    Optional<Usuario> pesquisaUsuarioPorCPF(@Param("cpf") String cpf);

    /**
     * Recupera usuário por nome
     *
     * @param nome - Nome do usuário
     *
     * @return Optional<Usuario> - Objeto optional com o registro do usuário
     *
     * @author Jean Varela
     * data    18/09/2021
     */
    @Query(value = "select usuario from Usuario usuario where usuario.nome = :nome")
    Optional<Usuario> pesquisaUsuarioPorNome(@Param("nome") String nome);

    /**
     * Recupera usuário por e-mail
     *
     * @param nome - Nome do usuário
     *
     * @return Optional<Usuario> - Objeto optional com o registro do usuário
     *
     * @author Jean Varela
     * data    18/09/2021
     */
    @Query(value = "select usuario from Usuario usuario where usuario.email = :email")
    Optional<Usuario> pesquisaUsuarioPorEmail(@Param("email") String email);
}
