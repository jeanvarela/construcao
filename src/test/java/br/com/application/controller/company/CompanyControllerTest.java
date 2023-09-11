package br.com.application.controller.company;

import br.com.application.model.dto.AddressDTO;
import br.com.application.model.dto.CompanyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public  void whenSendRequestWithCompanyObjectWithCorrectValues_thenReturnResponseWithStatusCode200() throws Exception {
        CompanyDTO company = this.createObjectCompanyValid();
        String payload = objectMapper.writeValueAsString(company);

        mockMvc.perform(post("/company").contentType(MediaType.APPLICATION_JSON)
                                                  .content(payload))
                                                  .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void whenSendRequestForCreateCompanyWithoutName_thenReturnBadRequest() throws Exception {
        CompanyDTO company = CompanyDTO.builder().build();

        String payload = objectMapper.writeValueAsString(company);

        mockMvc.perform(post("/company")
               .contentType(MediaType.APPLICATION_JSON)
               .content(payload))
               .andExpect(status().is4xxClientError())
               .andExpect(jsonPath("$.objects", Matchers.containsInAnyOrder(
                        Matchers.allOf(
                                Matchers.hasEntry("name", "email"),
                                Matchers.hasEntry("userMessage", "email é obrigatório")
                        ),
                        Matchers.allOf(
                                Matchers.hasEntry("name", "federalTaxPayerId"),
                                Matchers.hasEntry("userMessage", "federalTaxPayerId é obrigatório")
                        ),
                        Matchers.allOf(
                                Matchers.hasEntry("name", "name"),
                                Matchers.hasEntry("userMessage", "name é obrigatório")
                        ),
                        Matchers.allOf(
                                Matchers.hasEntry("name", "address"),
                                Matchers.hasEntry("userMessage", "must not be null")
                        ),
                        Matchers.allOf(
                                Matchers.hasEntry("name", "phone"),
                                Matchers.hasEntry("userMessage", "phone é obrigatório")
                        )
               )));
    }

    private CompanyDTO createObjectCompanyValid(){
        AddressDTO addressDTO = AddressDTO.builder()
                                 .city("São Paulo")
                                 .neighborhood("Consolação")
                                 .state("SP")
                                 .number(123)
                                 .street("Avenida Brasil")
                                 .zipCode("5465787")
                                 .build();

        return   CompanyDTO.builder()
                           .name("companyName")
                           .email("company@company.com")
                           .phone("819945454")
                           .federalTaxPayerId("05163245323")
                           .address(addressDTO)
                           .build();
    }
}
