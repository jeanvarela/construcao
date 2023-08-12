package br.com.application.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AddressDTO {

    private String street;
    private long   number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
}
