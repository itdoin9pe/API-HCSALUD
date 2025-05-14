package com.saludSystem.application.dtos.Operaciones.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearCategotiaMatDTO {

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de categorias materiales", example = "0")
    private Integer estado;

}