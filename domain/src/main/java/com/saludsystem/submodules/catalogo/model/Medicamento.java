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
}