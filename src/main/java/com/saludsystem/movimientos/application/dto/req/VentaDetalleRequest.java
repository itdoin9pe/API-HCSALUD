package com.saludsystem.movimientos.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class VentaDetalleRequest {

    private UUID productoId;

    private UUID ventaId;

    private String codigoProducto;

    @Schema(example = "0")
    private Integer cantidad;

    @Schema(example = "0")
    private Double precioUnitario;

    @Schema(example = "0")
    private Double subtotal;

}