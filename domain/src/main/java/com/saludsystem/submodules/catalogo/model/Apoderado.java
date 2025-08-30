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
}