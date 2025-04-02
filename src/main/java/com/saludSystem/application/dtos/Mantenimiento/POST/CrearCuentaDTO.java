package com.saludSystem.application.dtos.Mantenimiento.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearCuentaDTO {

    private String nombre;

    @Schema(description = "Total de cuentas a pagar", example = "0")
    private Integer total;

    @Schema(description = "Estado de cuentas a pagar (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}