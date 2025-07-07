package com.saludsystem.application.dtos.principal.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearEstudioDTO {

    @Schema(description = "Descripción de estudios", example = "string")
    private String descripcion;

}