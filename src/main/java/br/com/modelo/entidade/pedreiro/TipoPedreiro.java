package br.com.modelo.entidade.pedreiro;

import br.com.modelo.entidade.Entidade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe para representar a entidade tipo_pedreiro
 *
 * A entidade tipo_pedreiro armazena os tipos de pedreiro
 *
 * @author Jean Varela
 * data    29/04/2021
 */
@Entity
@Getter
@Setter
public class TipoPedreiro extends Entidade {

    @Column(name = "descricao", nullable=false)
    private String descricao;
}
