package com.saludsystem.application.dtos.catalogo.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoCitadoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID tipoCitadoId;

    private String nombre;

    private String color;

    @Schema(description = "Estado del Tipo Citado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}