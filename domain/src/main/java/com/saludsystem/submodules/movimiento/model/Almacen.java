package com.saludsystem.submodules.movimiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Almacen {
    private UUID almacenId;
    private String nombre;
    private Integer estado;
    private UUID sedeId;
    private UUID sucursalId;

    public Almacen(UUID almacenId, String nombre, Integer estado, UUID sedeId, UUID sucursalId) {
    	this.almacenId=almacenId;
    	this.nombre=nombre;
    	this.estado=estado;
    	this.sedeId=sedeId;
    	this.sucursalId=sucursalId;
    }
}