package com.saludSystem.application.dtos.Movimientos.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearAlmacenDTO {

    private String nombre;

    private String descripcion;

    private String ubicacion;

    @Schema(description = "estadoAlmacen", example = "0")
    private Integer estado;

}