package com.saludsystem.application.dtos.mantenimiento.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarCajaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID cajaId;

    private String nombre;

    @Schema(description = "Estado de Cajas (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}