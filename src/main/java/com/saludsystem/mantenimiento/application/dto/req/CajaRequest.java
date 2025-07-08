package com.saludsystem.mantenimiento.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CajaRequest {

    private String nombre;

    @Schema(description = "Estado de Cajas (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}