package br.com.application.configuration.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI buildHeaderSwagger(){
        return new OpenAPI().info(createInfo());
    }

    private Info createInfo(){
        return new Info().title("API Construtor")
                         .version("V1")
                         .description("API do sistema Construtor");
    }
}