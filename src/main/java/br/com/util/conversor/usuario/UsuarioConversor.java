package br.com.util.conversor.usuario;

import br.com.modelo.entidade.usuario.Usuario;
import br.com.util.conversor.IConversor;
import br.com.util.dto.usuario.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Realiza a conversão entre Usuario e UsuarioDTO
 *
 * @author Jean Varela
 * data    15/09/2021
 */
@Component
public class UsuarioConversor implements IConversor<UsuarioDTO,Usuario> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Usuario converteParaEntidade(UsuarioDTO objeto) {
        return modelMapper.map(objeto,Usuario.class);
    }

    @Override
    public UsuarioDTO converteParaDTO(Usuario entidade) {
        return modelMapper.map(entidade,UsuarioDTO.class);
    }
}
