package br.com.controlador.usuario;

import br.com.util.dto.usuario.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controlador para receber as requisições para o gerenciamento do cadastro do usuário
 *
 * @author Jean Varela
 * data    11/08/2021
 */
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioControlador {

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = null;//this.usuarioServico.atualizar(usuarioDTO);

        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }
}
