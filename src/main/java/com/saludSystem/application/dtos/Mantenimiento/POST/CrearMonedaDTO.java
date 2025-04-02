package com.saludSystem.application.dtos.Mantenimiento.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearMonedaDTO {

    private String descripcion;

    @Schema(description = "Estado del tipo de moneda (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}