package com.saludsystem.submodules.movimiento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Inventario {

    private UUID id;
    private UUID almacenId;
    private int tipoInventarioId;
    private UUID productoId;
    private UUID marcaId;
    private UUID categoriaId;
    private UUID unidadId;
    private BigDecimal precioEntrada;
    private BigDecimal precioSalida;
    private Integer stock;
    private LocalDate fecha;
    private Integer estado;

}