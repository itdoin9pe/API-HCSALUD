package com.saludsystem.submodules.catalogo.model;

import java.util.UUID;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Alergia {
    private UUID id;
    private String nombre;
    private Integer estado;
    
    public Alergia(UUID id, String nombre, Integer estado) {
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}