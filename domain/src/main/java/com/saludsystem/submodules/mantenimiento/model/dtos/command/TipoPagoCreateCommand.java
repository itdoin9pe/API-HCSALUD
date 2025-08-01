package com.saludsystem.submodules.mantenimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagoCreateCommand {

    private String metodoPago;

    private String descripcion;

    @Schema(description = "Estado de Tipo de pago (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}