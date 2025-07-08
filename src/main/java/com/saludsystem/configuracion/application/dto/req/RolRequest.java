package com.saludsystem.configuracion.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RolRequest {

    @Schema(description = "Estado del rol (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

    private String nombre;

}