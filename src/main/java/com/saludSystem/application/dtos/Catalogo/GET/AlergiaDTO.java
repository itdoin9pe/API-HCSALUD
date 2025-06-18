package com.saludSystem.application.dtos.Catalogo.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class AlergiaDTO {
    private UUID alergiaId;
    private String nombre;
    @Schema(description = "Estado de Alergias (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}