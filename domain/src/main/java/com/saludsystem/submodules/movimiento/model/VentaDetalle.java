package com.saludsystem.submodules.movimiento.model;

import com.saludsystem.submodules.operaciones.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class VentaDetalle {

    private UUID ventaDetalleId;
    private Producto producto;
    private String codigoProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;

}
