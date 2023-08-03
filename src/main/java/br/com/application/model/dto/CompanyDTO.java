package br.com.application.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CompanyDTO {

    @NotBlank
    private String name;
}
