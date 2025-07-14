package com.saludsystem.submodules.movimiento.port.in.service;

import java.math.BigDecimal;

public interface InventarioProjection {
    String getNombreAlmacen();
    String getNombreProducto();
    String getNombreMarca();
    String getNombreCategoria();
    BigDecimal getPrecioEntrada();
    String getUnidad();
    Integer getStock();
}