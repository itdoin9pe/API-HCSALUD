package com.saludsystem.mantenimiento.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarTipoPagoDTO extends BaseDTO {

    private UUID tipoPagoId;

    private String metodoPago;

    private String descripcion;

    @Schema(description = "Estado de Tipo de pago (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
