package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter 
@NoArgsConstructor
public class Consentimiento {
    private UUID id;
    private String nombre;
    private String observacion;
    private Integer estado;
    private String texto;
    
    public Consentimiento(UUID id, String nombre, String observacion, Integer estado, String texto) {
    	this.id = id;
    	this.nombre = nombre;
    	this.observacion = observacion;
    	this.estado = estado;
    	this.texto = texto;
    }
    
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
    }
    public void actualizarObservacion(String observacion) {
    	if (observacion != null && !observacion.isBlank()) {
			this.observacion=observacion;
		}
    }
    public void actualizarEstado(Integer estado) {
    	if (estado != null) {
			this.estado=estado;
		}
    }
    public void actualizarTexto(String texto) {
    	if (texto != null && !texto.isBlank()) {
			this.texto=texto;
		}
    }
}