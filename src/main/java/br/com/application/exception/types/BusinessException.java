package br.com.application.exception.types;

public class BusinessException  extends RuntimeException {
    private Object[] parameters;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }
}