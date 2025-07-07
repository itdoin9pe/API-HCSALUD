package com.saludsystem.movimientos.application.service;

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