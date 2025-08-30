package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter 
@NoArgsConstructor
public class Cliente {
    private UUID id;
    private String tipoDocumento;
    private String nombre;
    private String direccion;
    private String contacto;
    private String telefono;
    private String email;
    private Integer estado;
    
    public Cliente(UUID id, String tipoDocumento, String nombre, String direccion, String contacto, String telefono,
    		String email, Integer estado) {
    	this.id = id;
    	this.tipoDocumento = tipoDocumento;
    	this.nombre = nombre;
    	this.direccion = direccion;
    	this.contacto = contacto;
    	this.telefono = telefono;
    	this.email = email;
    	this.estado = estado;
    }
}