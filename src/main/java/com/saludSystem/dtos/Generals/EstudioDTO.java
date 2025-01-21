package com.saludSystem.dtos.Generals;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class EstudioDTO {
    @Schema(description = "ID de la aseguradora", example = "Integer")
    private Integer id;

    @Schema(description = "Descripción de la aseguradora", example = "string")
    private String descripcion;
}
