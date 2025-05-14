package com.saludSystem.application.dtos.Operaciones.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearPresentacionDTO {

    private String nombre;

    @Schema(description = "Estado de presentacion", example = "0")
    private Integer estado;

}