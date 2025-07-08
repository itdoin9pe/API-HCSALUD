package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TarifarioListResponse {

    @Schema(description = "Lista de Tarifarios")
    private List<com.saludsystem.mantenimiento.application.dto.res.TarifarioResponse> data;

    @Schema(description = "Numero total de tarifarios", example = "0")
    private long totalData;

}