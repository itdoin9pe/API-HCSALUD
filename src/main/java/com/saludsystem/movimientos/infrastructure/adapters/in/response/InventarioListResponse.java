package com.saludsystem.movimientos.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class InventarioListResponse {

    @Schema(description = "Lista de registros para Inventario")
    private List<com.saludsystem.movimientos.application.dto.res.InventarioResponse> data;

    @Schema(description = "Total de registros para Inventario", example = "0")
    private long totalData;

}