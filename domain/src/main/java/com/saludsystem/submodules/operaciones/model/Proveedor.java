package com.saludsystem.submodules.operaciones.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Proveedor {
    private UUID proveedorId;
    private String ruc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String contacto;

    public Proveedor(UUID proveedorId, String ruc, String nombre, String direccion, String telefono, String correo, 
    		String contacto) {
    	this.proveedorId=proveedorId;
    	this.ruc=ruc;
    	this.nombre=nombre;
    	this.direccion=direccion;
    	this.telefono=telefono;
    	this.correo=correo;
    	this.contacto=contacto;
    }
}