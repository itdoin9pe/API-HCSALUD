package com.saludSystem.infrastructure.adapters.in.response.Movimientos;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CompraResponse {

    @Schema(description = "Lista de registos de compras")
    private List<CompraDTO> data;

    @Schema(description = "Total de registro de compras", example = "0")
    private long totalData;

}
