package br.com.util;


import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Classe utilitária para armazenas os métodos de validação
 *
 * @author Jean Varela
 * data     18/09/2021
 */
public class ValidadorUtil {

    /**
     * Método utilizado para validar se o número do cnpj é válido
     *
     * @param cpf - Número do cpf a ser validado
     * @return - Boolean indicando se o CPF é válido
     *
     * @author Jean
     * @date   18/09/2021
     */
    public static boolean validaCPF(String cpf){
        CPFValidator validador = new CPFValidator();
        /**
         * Retorna uma lista de erros gerados na validação
         */
        List<ValidationMessage> mensagensValidacao = validador.invalidMessagesFor(cpf);

        /**
         * Se a lista não tiver erros, significa que o CPF é válido
         */
        return CollectionUtils.isEmpty(mensagensValidacao);
    }
}
