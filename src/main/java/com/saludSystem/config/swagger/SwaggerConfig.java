package com.saludSystem.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info().title("Spring boot REST API - SysSalud").description("Software SysSalud")
                .contact(new Contact().name("V1 API - A")).version("1.0.1"));
    }

}
