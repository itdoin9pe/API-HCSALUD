package com.saludsystem.submodules.configuracion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter 
@NoArgsConstructor
public class SysSalud {
    private UUID id;
    private String nombre;
    private String direccion;
    private String celular;
    private String email;
    private String ruc;
    private Date fecha;
    private String foto;
    private Integer estado;
    private UUID planId;
    
    public SysSalud(UUID id, String nombre, String direccion, String celular, String email, String ruc, 
    		Date fecha, String foto, Integer estado, UUID planId) {
    	this.id=id;
    	this.nombre=nombre;
    	this.direccion=direccion;
    	this.celular=celular;
    	this.email=email;
    	this.ruc=ruc;
    	this.fecha=fecha;
    	this.foto=foto;
    	this.estado=estado;
    	this.planId=planId;
    }
}