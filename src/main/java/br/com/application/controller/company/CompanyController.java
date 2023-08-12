package br.com.application.controller.company;

import br.com.application.mapper.InputCompanyMapper;
import br.com.application.mapper.UserMapper;
import br.com.application.model.dto.CompanyDTO;
import br.com.application.model.response.CompanyResponseDTO;
import br.com.service.company.CreateCompanyService;
import br.com.service.model.CompanyTO;
import br.com.service.model.UserTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final InputCompanyMapper companyMapper;
    private final UserMapper userMapper;
    private final CreateCompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> createOrder(@Valid  @RequestBody CompanyDTO companyDTO)  {
        CompanyTO company = this.companyMapper.convertCompanyDTOToCompanyTO(companyDTO);
        UserTO user = this.userMapper.convertUserDTOToUserTO(companyDTO.getMainUser());

        CompanyTO companySaved = this.companyService.crateCompany(company, user);
        return ResponseEntity.ok(this.companyMapper.convertCompanyTOToCompanyDTO(companySaved));
    }
}