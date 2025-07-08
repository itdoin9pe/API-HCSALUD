package com.saludsystem.mantenimiento.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MonedaListResponse {

    @Schema(description = "Lista de Tipo de Monedas")
    private List<com.saludsystem.mantenimiento.application.dto.res.MonedaResponse> data;

    @Schema(description = "Número total de Tipos de Monedas", example = "0")
    private long totalData;

}