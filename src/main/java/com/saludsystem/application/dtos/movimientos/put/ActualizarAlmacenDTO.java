package com.saludsystem.application.dtos.movimientos.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarAlmacenDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID almacenId;

    private UUID sedeId;

    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;

}