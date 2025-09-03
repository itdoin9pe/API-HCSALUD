package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Medicamento {
    private UUID id;
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    private Integer estado;
    
    public Medicamento(UUID id, String nombre, String formaFarmaceutica, String concentracion, 
    		String contenido, Integer estado) {
    	this.id = id;
    	this.nombre = nombre;
    	this.formaFarmaceutica = formaFarmaceutica;
    	this.concentracion = concentracion;
    	this.contenido = contenido;
    	this.estado = estado;
    }
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
    }
    public void actualizarFormaFarmaceutica(String formaFarmaceutica) {
    	if (formaFarmaceutica != null && !formaFarmaceutica.isBlank()) {
			this.formaFarmaceutica=formaFarmaceutica;
		}
    }
    public void actualizarConcentracion(String concentracion) {
    	if (concentracion != null && !concentracion.isBlank()) {
			this.concentracion=concentracion;
		}
    }
    public void actualizarContenido(String contenido) {
    	if (contenido != null && contenido.isBlank()) {
			this.contenido=contenido;
		}
    }
    public void actualizarEstado(Integer estado) {
    	if (estado != null) {
			this.estado=estado;
		}
    }
}