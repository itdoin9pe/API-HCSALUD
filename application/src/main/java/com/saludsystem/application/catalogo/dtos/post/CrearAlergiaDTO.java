package com.saludsystem.application.catalogo.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearAlergiaDTO {
    private String nombre;

    @Schema(description = "Estado (0=Inactivo, 1=Activo)", example = "1")
    private Integer estado;
}