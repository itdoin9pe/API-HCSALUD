package com.saludsystem.application.dtos.catalogo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class AlergiaDTO {
    private UUID alergiaId;
    private String nombre;
    @Schema(description = "Estado (0=Inactivo, 1=Activo)", example = "1")
    private Integer estado;
}