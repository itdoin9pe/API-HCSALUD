package com.saludsystem.submodules.mantenimiento.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Banco {
    private UUID id;
    private String descripcion;
    private Integer estado;

    public Banco(UUID id, String descripcion, Integer estado){
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}