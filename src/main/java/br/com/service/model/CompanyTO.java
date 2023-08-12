package br.com.service.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyTO {

        private String name;
        private String phone;
        private String email;
        private String federalTaxPayerId;
        private AddressTO address;
        private UserTO  mainUser;
}
