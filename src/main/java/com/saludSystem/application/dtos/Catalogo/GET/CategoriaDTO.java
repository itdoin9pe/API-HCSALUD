package com.saludSystem.application.dtos.Catalogo.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoriaDTO {

    private UUID categoriaId;

    private String nombre;

    @Schema(description = "Estado de la Categoria (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}