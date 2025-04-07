package com.saludSystem.application.dtos.Movimientos.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class AlmacenDTO {

    private UUID almacenId;

    private UUID sucursalEntity;

    private UUID hospital;

    private UUID user;

    private String nombre;

    private String descripcion;

    private String ubicacion;

    @Schema(description = "estadoAlmacen", example = "0")
    private Integer estado;

}