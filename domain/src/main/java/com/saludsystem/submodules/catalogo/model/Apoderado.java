package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Apoderado {
    private UUID id;
    private String nombre;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private Integer estado;
    
    public Apoderado(UUID id, String nombre, String nroDocumento, String direccion, String telefono, Integer estado) {
    	this.id = id;
    	this.nombre = nombre;
    	this.nroDocumento = nroDocumento;
    	this.direccion = direccion;
    	this.telefono = telefono;
    	this.estado = estado;
    }
    
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
    }
    public void actualizarNroDocumento(String nroDocumento) {
    	if (nroDocumento != null && !nroDocumento.isBlank()) {
			this.nroDocumento=nroDocumento;
		}
    }
    public void actualizarDireccion(String direccion) {
    	if (direccion != null && !direccion.isBlank()) {
			this.direccion=direccion;
		}
    }
    public void actualizarTelefono(String telefono) {
    	if (telefono != null && !telefono.isBlank()) {
			this.telefono=telefono;
		}
    }
    public void actualizarEstado(Integer estado) {
    	if (estado != null) {
			this.estado=estado;
		}
    }
}