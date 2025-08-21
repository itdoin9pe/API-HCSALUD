package com.saludsystem.submodules.movimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraDetalleCreateCommand {

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