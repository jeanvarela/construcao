package br.com.service.company;

import br.com.application.exception.types.BusinessException;
import br.com.repository.entity.Company;
import br.com.repository.CompanyRepository;
import br.com.service.mapper.CompanyEntityMapper;
import br.com.service.model.CompanyTO;
import br.com.service.model.UserTO;
import br.com.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class CreateCompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyEntityMapper companyEntityMapper;

    private final UserService userService;

    public CompanyTO crateCompany(CompanyTO companyTO, UserTO user){
        checkIfCompanyAlreadyExists(companyTO);
        this.userService.validateEmailUsed(user.getEmail());

        Company company = this.companyEntityMapper.convertToCompany(companyTO);
        Company companySaved =  this.companyRepository.save(company);

        userService.insertUserConstructor(user, companySaved.getId());

        return  companyEntityMapper.convertToCompanyTO(company);
    }

    private void checkIfCompanyAlreadyExists(CompanyTO companyTO) {
        Optional<Company> recoveredCompany = this.companyRepository.findCompanyByFederalTaxPayerIdAndName(companyTO.getFederalTaxPayerId(), companyTO.getName());

        if (recoveredCompany.isPresent()){
            throw new BusinessException("company.already.exists");
        }
    }
}
