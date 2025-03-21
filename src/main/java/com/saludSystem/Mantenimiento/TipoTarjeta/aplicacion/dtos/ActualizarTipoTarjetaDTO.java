package com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoTarjetaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID tipoTarjetaId;

    private String descripcion;

    @Schema(description = "Estado de Tipo de tarjeta (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
