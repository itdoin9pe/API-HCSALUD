package com.saludSystem.application.dtos.Catalogo.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarAlergiaDTO {

    private UUID alergiaDTO;

    private String nombre;

    @Schema(description = "Estado de Alergias (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}