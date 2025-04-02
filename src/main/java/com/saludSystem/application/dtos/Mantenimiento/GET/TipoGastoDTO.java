package com.saludSystem.application.dtos.Mantenimiento.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class TipoGastoDTO {

    private UUID conceptoGastoId;

    private String nombre;

    @Schema(description = "Estado de Tipos de gastos (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}