package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PermisoListResponse {

    @Schema(description = "Lista de Permisos")
    private List<com.saludsystem.configuracion.application.dto.res.PermisoResponse> data;

    @Schema(description = "Número total de Permisos", example = "0")
    private long totalData;

}