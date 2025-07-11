package com.saludsystem.application.mantenimiento.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarMonedaDTO extends BaseDTO {

    private UUID monedaId;

    private String descripcion;

    @Schema(description = "Estado del tipo de moneda (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
