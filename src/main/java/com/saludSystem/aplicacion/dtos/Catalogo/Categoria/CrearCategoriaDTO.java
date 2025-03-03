package com.saludSystem.aplicacion.dtos.Catalogo.Categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CrearCategoriaDTO {
    private String nombre;

    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la Categoria (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;
}