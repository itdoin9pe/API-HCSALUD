package com.saludsystem.submodules.operaciones.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Marca {
    private UUID id;
    private String nombre;
    private Integer estado;

    public Marca(UUID id, String nombre, Integer estado) {
    	this.id=id;
    	this.nombre=nombre;
    	this.estado=estado;
    }
}