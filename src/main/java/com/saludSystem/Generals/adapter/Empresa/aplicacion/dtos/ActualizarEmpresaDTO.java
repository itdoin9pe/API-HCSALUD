package com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ActualizarEmpresaDTO{

    private UUID hospitalId;

    private UUID usuarioId;

    private UUID empresaId;

    private String descripcion;

    @Schema(description = "Estado de la empresa (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}