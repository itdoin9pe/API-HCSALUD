package com.saludSystem.infrastructure.adapters.in.response.Movimientos;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDetalleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CompraDetalleResponse {

    @Schema(description = "Lista de registros - detalles de la compra")
    private List<CompraDetalleDTO> data;

    @Schema(description = "Total de registro - detalles de la compra", example = "0")
    private long totalData;

}