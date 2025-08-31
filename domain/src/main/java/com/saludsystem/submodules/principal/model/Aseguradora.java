package com.saludsystem.submodules.principal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Aseguradora {
    private UUID aseguradoraId;
    private String descripcion;
    private Integer estado;

    public Aseguradora(UUID aseguradoraId, String descripcion, Integer estado) {
    	this.aseguradoraId=aseguradoraId;
    	this.descripcion=descripcion;
    	this.estado=estado;
    }
}