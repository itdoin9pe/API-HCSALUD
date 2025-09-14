package com.saludsystem.submodules.config.swagger;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;

@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Salud System Api Rest", version = "1.1.0", description = "API REST para la gestión de pacientes"))
public class SwaggerConfig
{

	@Bean
	public OpenAPI notifOpenAPI()
	{
		return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info().title("Salud System API").version("1.1.0")
				.contact(new io.swagger.v3.oas.models.info.Contact()
						.name("Giancarlo Silva - Software Engineer / Alfonso Valencia - Software Engineer")
						.email("giancarlosilvagutierrez55@gmail.com"))
				.description("API REST para la gestión de pacientes"));
	}

	@Bean
	public OpenApiCustomizer sortOperationsByHttpMethodAndGroup()
	{
		return openApi -> {
			// Ordenar todos los paths por método HTTP (POST → GET → PUT → DELETE)
			openApi.getPaths().forEach((path, pathItem) -> {
				Map<PathItem.HttpMethod, Operation> orderedOperations = new LinkedHashMap<>();

				// Agregar en el orden deseado
				if (pathItem.getPost() != null)
				{
					orderedOperations.put(PathItem.HttpMethod.POST, pathItem.getPost());
				}
				if (pathItem.getGet() != null)
				{
					orderedOperations.put(PathItem.HttpMethod.GET, pathItem.getGet());
				}
				if (pathItem.getPut() != null)
				{
					orderedOperations.put(PathItem.HttpMethod.PUT, pathItem.getPut());
				}
				if (pathItem.getDelete() != null)
				{
					orderedOperations.put(PathItem.HttpMethod.DELETE, pathItem.getDelete());
				}

				// Reemplazar las operaciones existentes
				pathItem.readOperationsMap().clear();
				orderedOperations.forEach(pathItem::operation);
			});

			// Opcional: Ordenar los tags alfabéticamente
			if (openApi.getTags() != null)
			{
				openApi.setTags(openApi.getTags().stream().sorted(Comparator.comparing(tag -> tag.getName()))
						.collect(Collectors.toList()));
			}
		};
	}
}