package br.com.util.conversor;

import br.com.modelo.entidade.Entidade;

/**
 * Interface utilizada para definir o contrato para realizar
 * a conversão entre objetos DTOs e entidades
 *
 * @author Jean Varela
 * data    15/09/2021
 */
public interface IConversor<T,E extends Entidade> {

    /**
     * Realiza a conversão de um objeto DTO para um objeto Entidade
     *
     * @param objetoDTO - Registro do objeto DTO
     *
     * @return T - Objeto do tipo entidade
     *
     * @author Jean Varela
     * data    16/09/2021
     */
    E converteParaEntidade(T objetoDTO);

    /**
     * Realiza a conversão de um objeto entidade para um objeto DTO
     *
     * @param entidade - Registro do objeto Entidade
     *
     * @return E - Objeto do tipo DTO
     *
     * @author Jean Varela
     * data    16/09/2021
     */
    T converteParaDTO(E entidade);
}
