package br.com.controlador.pedreiro;

import br.com.modelo.entidade.pedreiro.TipoPedreiro;
import br.com.servico.pedreiro.TipoPedreiroServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Controlador para acessar os recursos de Tipo pedreiro
 *
 * @author Jean Varela
 * data    04/05/2021
 */
@RestController
@RequestMapping("/tipo-pedreiro")
public class TipoPedreiroControlador {

    private TipoPedreiroServico tipoPedreiroServico;

    @Autowired
    public TipoPedreiroControlador(TipoPedreiroServico tipoPedreiroServico) {
        this.tipoPedreiroServico = tipoPedreiroServico;
    }

    /**
     * Recupera a lista de Tipo Pedreiro
     *
     * @return List<TipoPedreiro> - Lista de tipo pedreiro
     *
     * @author Jean Varela
     * data    04/05/2021
     */
    @GetMapping
    public ResponseEntity<List<TipoPedreiro>>  recuperarLista(){
        List<TipoPedreiro> listaTipoPedreiro = this.tipoPedreiroServico.recuperarLista();

        return new ResponseEntity<>(listaTipoPedreiro, HttpStatus.OK);
    }
}
