package com.saludsystem.application.mantenimiento.dtos.put;

import com.saludsystem.application.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarTipoGastoDTO extends BaseDTO {

    private UUID conceptoGastoId;

    private String nombre;

    @Schema(description = "Estado de Tipos de gastos (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}
