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
}