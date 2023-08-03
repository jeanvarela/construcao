package br.com.application.model.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CompanyResponseDTO {

    @NotBlank
    private String name;
    private String phone;
    private String email;
}
