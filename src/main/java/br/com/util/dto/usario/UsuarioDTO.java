package br.com.util.dto.usario;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO para transportar informações sobre usuário
 *
 * @author Jean Varela
 * data    15/09/2021
 */
@Getter
@Setter
public class UsuarioDTO {

    private long   id;

    private String nome;

    private String email;

    private String senha;

}
