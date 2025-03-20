package com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarMonedaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID monedaId;

    private String descripcion;

    @Schema(description = "Estado del tipo de moneda (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}
