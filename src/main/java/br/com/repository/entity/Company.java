package br.com.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "cp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "cp_phone")
    private String phone;

    @NotBlank
    @Column(name = "cp_name")
    private String name;

    @NotBlank
    @Email
    @Column(name = "cp_email")
    private String email;

    @NotBlank
    @Column(name = "cp_federal_tax_payer_id")
    private String federalTaxPayerId;

    @NotBlank
    @Column(name = "cp_address_street")
    private String street;

    @Column(name = "cp_address_number")
    private long   number;

    @Column(name = "cp_address_neighborhood")
    private String neighborhood;

    @Column(name = "cp_address_city")
    private String city;

    @Column(name = "cp_address_zip_code")
    private String zipCode;
}