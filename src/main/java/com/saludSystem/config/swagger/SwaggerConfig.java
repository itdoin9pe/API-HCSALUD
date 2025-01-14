package com.saludSystem.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Salud System Api Rest",
                version = "1.1.0",
                description = "API REST para la gestión de pacientes"
        )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info().title("Spring boot REST API - SysSalud").description("Software SysSalud")
                .contact(new Contact().name("V1 API - A")).version("1.0.1"));
    }

}
