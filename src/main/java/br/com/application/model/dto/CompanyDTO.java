package br.com.application.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CompanyDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String federalTaxPayerId;

    @NotNull
    private AddressDTO address;

    @NotNull
    private UserDTO mainUser;
}
