package br.com.util.configuracoes.conversao;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configura o ModelMapper para o Spring conseguir
 * gerenciar os seus objetos
 *
 * @author Jean Varela
 * data    16/09/2021
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
