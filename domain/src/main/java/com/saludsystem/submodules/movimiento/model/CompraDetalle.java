package com.saludsystem.submodules.movimiento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CompraDetalle {

    private UUID compraDetalleId;

    private UUID compraId;

    private UUID productoId;

    private Integer cantidad;

    private BigDecimal precioUnitario;

    private BigDecimal igv;

    private BigDecimal precioVenta;

    private BigDecimal subtotal;

}
