package com.saludsystem.configuracion.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearRolDTO {

    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

    private String nombre;

}