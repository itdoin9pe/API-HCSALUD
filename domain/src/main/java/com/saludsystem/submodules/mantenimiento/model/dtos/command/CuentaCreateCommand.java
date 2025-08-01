package com.saludsystem.submodules.mantenimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaCreateCommand {

    private String nombre;

    @Schema(description = "Total de cuentas a pagar", example = "0")
    private Integer total;

    @Schema(description = "Estado de cuentas a pagar (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}