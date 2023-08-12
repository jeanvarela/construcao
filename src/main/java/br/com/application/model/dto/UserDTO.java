package br.com.application.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String name;
    private String cpf;
    private String email;
    private String password;
}