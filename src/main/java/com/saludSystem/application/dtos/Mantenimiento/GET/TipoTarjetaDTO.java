package com.saludSystem.application.dtos.Mantenimiento.GET;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class TipoTarjetaDTO {

    private UUID tipoTarjetaId;

    private String descripcion;

    @Schema(description = "Estado de Tipo de tarjeta (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}