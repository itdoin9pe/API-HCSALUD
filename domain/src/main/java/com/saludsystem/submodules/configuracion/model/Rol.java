package com.saludsystem.submodules.configuracion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Rol {
    private UUID roleId;
    private String nombre;
    private Integer estado;

    public Rol(UUID roleId, String nombre, Integer estado) {
    	this.roleId=roleId;
    	this.nombre=nombre;
    	this.estado=estado;
    }
}