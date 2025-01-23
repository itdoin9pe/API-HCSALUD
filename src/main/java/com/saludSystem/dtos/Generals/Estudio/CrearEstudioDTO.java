package com.saludSystem.dtos.Generals.Estudio;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearEstudioDTO {
    @Schema(description = "ID de Estudios", example = "Integer")
    private Integer id;

    @Schema(description = "Descripción de estudios", example = "string")
    private String descripcion;
}
