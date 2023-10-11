package br.com.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User {

    @Id
    @Column(name = "us_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "us_name")
    private String name;

    @Column(name = "us_cpf")
    private String cpf;

    @Column(name = "us_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "us_company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "us_user_type_id")
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "us_user_login_id")
    private UserLogin userLogin;
}