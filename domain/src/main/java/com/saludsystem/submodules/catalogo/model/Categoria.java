package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Categoria {
    private UUID id;
    private String nombre;
    private Integer estado;
    
    public Categoria(UUID id, String nombre, Integer estado) {
    	this.id = id;
    	this.nombre = nombre;
    	this.estado = estado;
    }
    
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
    }
    public void actualizarEstado(Integer estado) {
    	if (estado != null) {
			this.estado=estado;
		}
    }
}