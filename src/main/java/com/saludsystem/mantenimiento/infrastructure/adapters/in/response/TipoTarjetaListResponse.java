package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TipoTarjetaListResponse {

    @Schema(description = "Lista de Tipo de tarjetas")
    private List<com.saludsystem.mantenimiento.application.dto.res.TipoTarjetaResponse> data;

    @Schema(description = "Número total de tipos de tarjetas", example = "0")
    private long totalData;

}