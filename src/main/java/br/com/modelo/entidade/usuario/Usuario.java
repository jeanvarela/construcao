package br.com.modelo.entidade.usuario;

import br.com.modelo.entidade.Entidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe para representar a entidade usuário
 *
 * @author Jean Varela
 * data    16/04/2021
 */
@Getter
@Setter
@Entity
public class Usuario extends Entidade {

    @Column(name = "nome", nullable=false)
    private String nome;

    @Column(name = "email", nullable=false)
    private String email;

    @Column(name = "senha", nullable=false)
    private String senha;

    @Column(name = "cpf", nullable=false)
    private String cpf;
}
