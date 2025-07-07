package com.saludsystem.catalogo.application.dtos.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearCategoriaDTO {

    private String nombre;

    @Schema(description = "Estado de la Categoria (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}