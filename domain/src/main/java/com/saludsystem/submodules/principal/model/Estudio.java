package com.saludsystem.submodules.principal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Estudio {
    private UUID id;
    private String descripcion;

    public Estudio(UUID id, String descripcion) {
    	this.id=id;
    	this.descripcion=descripcion;
    }
}