package com.saludsystem.movimientos.infrastructure.adapters.in.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CompraListResponse {

    @Schema(description = "Lista de registos de compras")
    private List<com.saludsystem.movimientos.application.dto.res.CompraResponse> data;

    @Schema(description = "Total de registro de compras", example = "0")
    private long totalData;

}