package com.saludsystem.submodules.operaciones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Producto {

    private UUID id;
    private UUID marcaId;
    private UUID tipoMaterialId;
    private UUID unidadId;
    private UUID presentacionId;
    private UUID categoriaMatId;
    private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer stock;
    private String lote;
    private LocalDate fecha;
    private String estadoVenta;
    private String estadoCompra;
    private Integer estadoProducto;

}
