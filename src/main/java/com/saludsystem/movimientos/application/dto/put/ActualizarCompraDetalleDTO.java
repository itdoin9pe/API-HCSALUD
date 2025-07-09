package com.saludsystem.movimientos.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarCompraDetalleDTO extends BaseDTO {

    private UUID compraDetalleId;

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