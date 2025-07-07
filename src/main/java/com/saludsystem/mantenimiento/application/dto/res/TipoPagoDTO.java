package com.saludsystem.mantenimiento.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class TipoPagoDTO {

    private UUID tipoPagoId;

    private String metodoPago;

    private String descripcion;

    @Schema(description = "Estado de Tipo de pago (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}