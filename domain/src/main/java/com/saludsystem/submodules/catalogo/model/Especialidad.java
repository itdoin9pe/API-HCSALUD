package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Especialidad {
    private UUID id;
    private String nombre;
    private String descripcion;
    private Integer estado;

    public Especialidad(UUID id, String nombre, String descripcion, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
    }
    public void actualizarDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isBlank()) {
            this.descripcion = descripcion;
        }
    }
    public void actualizarEstado(Integer estado) {
        if (estado != null) this.estado = estado;
    }
}