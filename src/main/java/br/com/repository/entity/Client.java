package br.com.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "cl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "cl_name")
    private String name;

    @NotBlank
    @Column(name = "cl_cpf")
    private String cpf;

    @NotBlank
    @Column(name = "cl_cellphone")
    private String cellphone;

    @NotBlank
    @Column(name = "cl_email")
    private String email;

    @NotBlank
    @Column(name = "cl_address_street")
    private String addressStreet;

    @NotBlank
    @Column(name = "cl_address_number")
    private Integer addressNumber;

    @NotBlank
    @Column(name = "cl_address_neighborhood")
    private String addressNeighborhood;

    @NotBlank
    @Column(name = "cl_address_city")
    private String addressCity;

    @NotBlank
    @Column(name = "cl_address_zip_code")
    private String addressZipCode;

    @NotBlank
    @Column(name = "cl_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "cl_user_login_id")
    private UserLogin userLogin;
}