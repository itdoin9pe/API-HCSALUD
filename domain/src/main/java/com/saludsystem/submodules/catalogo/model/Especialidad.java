package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Especialidad {
    private UUID id;
    private String nombre;
    private String descripcion;
    private Integer estado;

    public Especialidad(UUID id, String nombre, String descripcion, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Especialidad() {

    }
}
