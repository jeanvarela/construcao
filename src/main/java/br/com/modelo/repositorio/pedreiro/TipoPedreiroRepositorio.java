package br.com.modelo.repositorio.pedreiro;

import br.com.modelo.entidade.pedreiro.TipoPedreiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para gerenciar a entidade TipoPedreiro
 *
 * @author Jean Varela
 * data    04/05/2021
 */
@Repository
public interface TipoPedreiroRepositorio extends JpaRepository<TipoPedreiro,Long> {
}
