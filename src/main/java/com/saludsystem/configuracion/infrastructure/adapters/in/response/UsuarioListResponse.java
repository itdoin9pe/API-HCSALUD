package com.saludsystem.configuracion.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioListResponse {

    @Schema(description = "Lista de Usuarios")
    private List<com.saludsystem.configuracion.application.dto.res.UsuarioResponse> data;

    @Schema(description = "Número total de Usuarios", example = "0")
    private long totalData;

}