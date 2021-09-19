package br.com.util.dto.usuario;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO para traafegar as informações do Usuário
 *
 * @author Jean Varela
 * data    11/08/2021
 */
@Getter
@Setter
public class UsuarioDTO {

    @NotNull
    @NotBlank
    private String nome;

    @NotBlank
    @NotNull(message = "Nome não pode ser nulo")
    @Email(message = "E-mail inválido")
    private String email;

    private String senha;

    private String cpf;
}
