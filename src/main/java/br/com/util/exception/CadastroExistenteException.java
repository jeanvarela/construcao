package br.com.util.exception;

/**
 * Exception lançado quando for verificado que algum cadastro já existe
 *
 * @author Jean Varela
 * data    18/09/2021
 */
public class CadastroExistenteException extends RuntimeException {

    public CadastroExistenteException(String message) {
        super(message);
    }
}
