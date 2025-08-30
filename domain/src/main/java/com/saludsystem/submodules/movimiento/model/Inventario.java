package com.saludsystem.submodules.movimiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
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

    public Inventario(UUID id, UUID almacenId, int tipoInventarioId, UUID productoId, UUID marcaId, 
    		UUID categoriaId, UUID unidadId, BigDecimal precioEntrada, BigDecimal precioSalida, 
    		Integer stock, LocalDate fecha, Integer estado) {
    	this.id=id;
    	this.almacenId=almacenId;
    	this.tipoInventarioId=tipoInventarioId;
    	this.productoId=productoId;
    	this.marcaId=marcaId;
    	this.categoriaId=categoriaId;
    	this.unidadId=unidadId;
    	this.precioEntrada=precioEntrada;
    	this.precioSalida=precioSalida;
    	this.stock=stock;
    	this.fecha=fecha;
    	this.estado=estado;
    }
}