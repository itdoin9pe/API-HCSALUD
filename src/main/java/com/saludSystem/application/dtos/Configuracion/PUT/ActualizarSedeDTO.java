package com.saludSystem.application.dtos.Configuracion.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarSedeDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID sedeId;

    private String codigo;

    private String nombre;

    private String direccion;

    private String ubigeo;

    @Schema(description = "Estado de la sede (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}