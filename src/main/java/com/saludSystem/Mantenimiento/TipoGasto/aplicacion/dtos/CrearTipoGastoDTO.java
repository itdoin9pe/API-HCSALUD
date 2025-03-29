package com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearTipoGastoDTO {

    private String nombre;

    @Schema(description = "Estado de Tipos de gastos (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}