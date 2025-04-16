package com.saludSystem.infrastructure.adapters.in.response.Movimientos;

import com.saludSystem.application.dtos.Movimientos.GET.VentaDetalleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VentaDetalleResponse {

    @Schema(description = "Lista de registro para detalles de venta")
    private List<VentaDetalleDTO> data;

    @Schema(description = "Total de registros para detalles de la venta", example = "0")
    private long totalData;

}