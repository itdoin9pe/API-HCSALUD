package com.saludsystem.submodules.mantenimiento.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CuentaEditCommand extends BaseDTO {

    private UUID cuentaPagarId;

    private String nombre;

    @Schema(description = "Total de cuentas a pagar", example = "0")
    private Integer total;

    @Schema(description = "Estado de cuentas a pagar (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}