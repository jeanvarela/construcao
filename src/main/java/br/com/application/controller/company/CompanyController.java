package br.com.application.controller.company;

import br.com.application.model.response.CompanyResponseDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @PostMapping
    public CompanyResponseDTO createOrder(@Valid  @RequestBody CompanyResponseDTO comapny)  {
        return new CompanyResponseDTO();
    }
}