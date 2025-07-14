package com.saludsystem.infrastructure.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
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
    public OpenAPI notifOpenAPI() {
        OpenAPI openAPI = new OpenAPI();
        openAPI.info(new io.swagger.v3.oas.models.info.Info()
                .title("Sample Service API")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .name("Giancarlo Silva - Software Engineer / Alfonso Valencia - Software Engineer")
                        .email("giancarlosilvagutierrez55@gmail.com"))
                .termsOfService("TOC")
                .license(new io.swagger.v3.oas.models.info.License().name("License")));
        return openAPI;
    }
}