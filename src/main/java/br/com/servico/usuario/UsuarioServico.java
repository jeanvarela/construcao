package br.com.servico.usuario;

import br.com.modelo.entidade.usuario.Usuario;
import br.com.modelo.repositorio.usuario.UsuarioRepositorio;
import br.com.util.conversor.usuario.UsuarioConversor;
import br.com.util.dto.usario.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço para gerenciar as informações de usuário
 *
 * @author Jean Varela
 * data    15/09/2021
 */
@Service
public class UsuarioServico {

    private UsuarioRepositorio usuarioRepositorio;

    private UsuarioConversor   usuarioConversor;

    @Autowired
    public UsuarioServico(UsuarioRepositorio usuarioRepositorio, UsuarioConversor usuarioConversor) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.usuarioConversor   = usuarioConversor;
    }

    /**
     * Cadastar usuário
     *
     * @param usuarioDTO - Objeto UsuarioDTO recebido da requisição
     *
     * @return usuarioDTO - Objeto UsuarioDTO gerado a partir do usuário cadastrado
     *
     * @author Jean Varela
     * data    16/09/2021
     */
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = this.usuarioConversor.converteParaEntidade(usuarioDTO);

        Usuario usuarioPersistido = this.usuarioRepositorio.save(usuario);

        return this.usuarioConversor.converteParaDTO(usuarioPersistido);
    }
}
