package br.com.util.exception;

/**
 * Exception lançado quando for verificado que já existe usuário com o mesmo CPF ou o CPF não for valido
 *
 * @author Jean Varela
 * data    18/09/2021
 */
public class CPFException extends RuntimeException {

    public CPFException(String message) {
        super(message);
    }
}
