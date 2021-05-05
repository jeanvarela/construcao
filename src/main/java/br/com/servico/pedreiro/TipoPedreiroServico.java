package br.com.servico.pedreiro;

import br.com.modelo.entidade.pedreiro.TipoPedreiro;
import br.com.modelo.repositorio.pedreiro.TipoPedreiroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Serviço para gerenciar as informações de Tipo Pedreiro
 *
 * @author Jean Varela
 * data     04/05/2021
 */
@Service
public class TipoPedreiroServico {

    private TipoPedreiroRepositorio tipoPedreiroRepositorio;

    @Autowired
    public TipoPedreiroServico(TipoPedreiroRepositorio tipoPedreiroRepositorio){
        this.tipoPedreiroRepositorio = tipoPedreiroRepositorio;
    }

    /**
     * Recupera lista de tipos de pedreiros
     *
     * @return List - Lista de pedreiros
     *
     * @author Jean Varela
     * data    04/05/2021
     */
    public List<TipoPedreiro> recuperarLista(){
        return this.tipoPedreiroRepositorio.findAll();
    }
}
