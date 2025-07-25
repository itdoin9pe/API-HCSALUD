package com.saludsystem.submodules.operaciones.model.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearUnidadDTO {

    private String nombre;

    private String siglas;

    private String descripcion;

    @Schema(description = "Estado de la unidad", example = "0")
    private Integer estado;

}