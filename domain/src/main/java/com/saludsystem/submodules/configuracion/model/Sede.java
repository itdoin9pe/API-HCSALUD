package com.saludsystem.submodules.configuracion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Sede {
    private UUID id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    private Integer estado;
    private UUID sucursalId;
    
    public Sede(UUID id, String codigo, String nombre, String direccion, String ubigeo, Integer estado, UUID sucursalId) {
    	this.id=id;
    	this.codigo=codigo;
    	this.nombre=nombre;
    	this.direccion=direccion;
    	this.ubigeo=ubigeo;
    	this.estado=estado;
    	this.sucursalId=sucursalId;
    }
}