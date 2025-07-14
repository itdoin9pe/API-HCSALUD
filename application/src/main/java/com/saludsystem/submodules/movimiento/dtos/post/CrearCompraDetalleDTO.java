package com.saludsystem.submodules.movimiento.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CrearCompraDetalleDTO {

    private UUID compraId;
    private UUID productoId;

    @Schema(example = "0")
    private int cantidad;

    @Schema(example = "0")
    private BigDecimal precioUnitario;

    @Schema(example = "0")
    private BigDecimal igv;

    @Schema(example = "0")
    private BigDecimal precioVenta;

    @Schema(example = "0")
    private BigDecimal subtotal;

}