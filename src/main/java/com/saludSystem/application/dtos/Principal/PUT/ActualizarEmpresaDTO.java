package com.saludSystem.application.dtos.Principal.PUT;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarEmpresaDTO{

    private UUID hospitalId;

    private UUID usuarioId;

    private UUID empresaId;

    private String descripcion;

    @Schema(description = "Estado de la empresa (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}