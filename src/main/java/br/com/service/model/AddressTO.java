package br.com.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressTO {
    private String street;
    private long   number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
}
