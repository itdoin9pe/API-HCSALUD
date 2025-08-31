package com.saludsystem.submodules.principal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Empresa {
    private UUID empresaId;
    private String descripcion;
    private Integer estado;

    public Empresa(UUID empresaId, String descripcion, Integer estado) {
    	this.empresaId=empresaId;
    	this.descripcion=descripcion;
    	this.estado=estado;
    }
}