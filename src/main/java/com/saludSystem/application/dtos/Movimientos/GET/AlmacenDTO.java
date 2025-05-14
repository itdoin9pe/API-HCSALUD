package com.saludSystem.application.dtos.Movimientos.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class AlmacenDTO {

    private UUID almacenId;

    private UUID sedeId;

    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;

}