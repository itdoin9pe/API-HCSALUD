package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CuentaListResponse {

    @Schema(description = "Lista de Alergias")
    private List<com.saludsystem.mantenimiento.application.dto.res.CuentaResponse> data;

    @Schema(description = "Número total de Alergias Registradas", example = "0")
    private long totalData;

}