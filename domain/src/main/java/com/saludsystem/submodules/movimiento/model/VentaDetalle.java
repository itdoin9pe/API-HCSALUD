package com.saludsystem.submodules.movimiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class VentaDetalle {
    private UUID ventaDetalleId;
    private UUID ventaId;
    private UUID productoId;
    private String codigoProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;
    
    public VentaDetalle(UUID ventaDetalleId, UUID ventaId, UUID productoId, String codigoProducto, 
    		Integer cantidad, BigDecimal precio, BigDecimal subtotal) {
    	this.ventaDetalleId=ventaDetalleId;
    	this.ventaId=ventaId;
    	this.productoId=productoId;
    	this.codigoProducto=codigoProducto;
    	this.cantidad=cantidad;
    	this.precio=precio;
    	this.subtotal=subtotal;
    }
}