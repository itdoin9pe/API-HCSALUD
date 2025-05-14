package com.saludSystem.application.dtos.Operaciones.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class TipoMaterialDTO {

    private UUID tipoMaterialId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado del tipo de material", example = "0")
    private Integer estado;

}