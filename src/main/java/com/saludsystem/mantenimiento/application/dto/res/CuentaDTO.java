package com.saludsystem.mantenimiento.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class CuentaDTO {

    private UUID cuentaPagarId;

    private String nombre;

    @Schema(description = "Total de cuentas a pagar", example = "0")
    private Integer total;

    @Schema(description = "Estado de cuentas a pagar (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}