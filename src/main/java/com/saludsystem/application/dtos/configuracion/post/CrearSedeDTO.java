package com.saludsystem.application.dtos.configuracion.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearSedeDTO {

    private String codigo;

    private String nombre;

    private String direccion;

    private String ubigeo;

    @Schema(description = "Estado de la sede (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}