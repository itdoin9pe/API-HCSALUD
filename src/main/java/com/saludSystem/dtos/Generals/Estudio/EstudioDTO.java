package com.saludSystem.dtos.Generals.Estudio;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EstudioDTO {
    @Schema(description = "ID de estudios educativos", example = "Integer")
    private Integer id;

    @Schema(description = "Descripción de estudio educativo", example = "string")
    private String descripcion;
}
