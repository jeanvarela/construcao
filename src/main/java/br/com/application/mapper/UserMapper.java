package br.com.application.mapper;

import br.com.application.model.dto.UserDTO;
import br.com.service.model.UserTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public  interface UserMapper {

    public abstract UserTO convertUserDTOToUserTO(UserDTO user);
}