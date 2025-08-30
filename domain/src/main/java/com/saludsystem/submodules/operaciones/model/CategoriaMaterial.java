package com.saludsystem.submodules.operaciones.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class CategoriaMaterial {
    private UUID categoriaMaterialId;
    private String nombre;
    private String descripcion;
    private Integer estado;

    public CategoriaMaterial(UUID categoriaMaterialId, String nombre, String descripcion, Integer estado) {
    	this.categoriaMaterialId=categoriaMaterialId;
    	this.nombre=nombre;
    	this.descripcion=descripcion;
    	this.estado=estado;
    }
}