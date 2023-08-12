package br.com.service.mapper;

import br.com.repository.entity.Company;
import br.com.service.model.CompanyTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper//(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyEntityMapper {

    @Mappings({
            @Mapping(target = "street", source = "company.address.street"),
            @Mapping(target = "number", source = "address.number"),
            @Mapping(target = "neighborhood", source = "company.address.neighborhood"),
            @Mapping(target = "city", source = "company.address.city"),
            @Mapping(target = "zipCode", source = "company.address.zipCode"),
    })
    public abstract Company convertToCompany(CompanyTO company);

    @Mappings({
            @Mapping(target = "address.street", source = "street"),
            @Mapping(target = "address.number", source = "number"),
            @Mapping(target = "address.neighborhood", source = "neighborhood"),
            @Mapping(target = "address.city", source = "city"),
            @Mapping(target = "address.zipCode", source = "zipCode"),
    })
    public abstract CompanyTO convertToCompanyTO(Company company);
}