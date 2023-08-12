package br.com.application.mapper;

import br.com.application.model.dto.CompanyDTO;
import br.com.application.model.response.CompanyResponseDTO;
import br.com.service.model.CompanyTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public  interface InputCompanyMapper {

    @Mappings({
            @Mapping(target = "address.street", source = "company.address.street"),
            @Mapping(target = "address.number", source = "company.address.number"),
            @Mapping(target = "address.neighborhood", source = "company.address.neighborhood"),
            @Mapping(target = "address.city", source = "company.address.city"),
            @Mapping(target = "address.state", source = "company.address.state"),
            @Mapping(target = "address.zipCode", source = "company.address.zipCode")
    })
    public abstract CompanyTO convertCompanyDTOToCompanyTO(CompanyDTO company);

    public abstract CompanyResponseDTO convertCompanyTOToCompanyDTO(CompanyTO company);
}