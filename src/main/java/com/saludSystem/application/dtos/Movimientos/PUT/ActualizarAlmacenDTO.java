package com.saludSystem.application.dtos.Movimientos.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarAlmacenDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID sucursalId;

    private UUID almacenId;

    private String nombre;

    private String descripcion;

    private String ubicacion;

    @Schema(description = "estadoAlmacen", example = "0")
    private Integer estado;

}