package br.com.controlador.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problema {

    private Integer status;
    private LocalDateTime dataHora;
    private String type;
    private String title;
    private String detail;
    private String mensagem;
    private List<Campo> campos;

    @Getter
    @Builder
    public static class Campo {

        private String nome;
        private String mensagem;

    }
}