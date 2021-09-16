package br.com.controlador.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Exception handler global
 *
 * @author jean.varela
 * data    12/08/2021
 */
@ControllerAdvice
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler {

    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL
            = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se "
            + "o problema persistir, entre em contato com o administrador do sistema.";

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<Problema.Campo> camposProblema = bindingResult.getFieldErrors().stream()
                .map(fieldError -> {
                    String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

                    return Problema.Campo.builder().nome(fieldError.getField())
                                                   .mensagem(mensagem)
                                                   .build();
                }).collect(Collectors.toList());

        Problema mensagem = Problema.builder()
                .mensagem("Um ou mais campos estão inválidos")
                .campos(camposProblema)
                .dataHora(LocalDateTime.now())
                .build();


        return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (body == null) {
            body = Problema.builder().dataHora(LocalDateTime.now())
                                     .title(status.getReasonPhrase())
                                     .status(status.value())
                                     .mensagem(MSG_ERRO_GENERICA_USUARIO_FINAL)
                                     .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
