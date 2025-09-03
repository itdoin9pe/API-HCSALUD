package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class TipoCitado {
    private UUID id;
    private String nombre;
    private String color;
    private Integer estado;

    public TipoCitado(UUID id, String nombre, String color, Integer estado) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (estado == null || (estado != 0 && estado != 1)) {
            throw new IllegalArgumentException("El estado debe ser 0 o 1");
        }
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.estado = estado;
    }
    
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
    }
    public void actualizarColor(String color) {
    	if (color != null && !color.isBlank()) {
    		this.color=color;
		}
    }
    public void actualizarEstado(Integer estado) {
    	if (estado != null) {
			this.estado=estado;
		}
    }
}