package br.com.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTO {

    private String name;
    private String cpf;
    private String email;
    private String password;
    private int    userTypeId;
}
