package com.saludSystem.application.dtos.Mantenimiento.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearTipoTarjetaDTO {

    private String descripcion;

    @Schema(description = "Estado de Tipo de tarjeta (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}