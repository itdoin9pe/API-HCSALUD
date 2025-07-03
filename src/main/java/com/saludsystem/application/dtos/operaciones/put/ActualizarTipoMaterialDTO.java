package com.saludsystem.application.dtos.operaciones.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoMaterialDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID tipoMaterialId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado del tipo de material", example = "0")
    private Integer estado;

}