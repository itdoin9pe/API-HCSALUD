package com.saludsystem.submodules.mantenimiento.model;

import lombok.Getter;

@Getter
public class Enfermedad {

    private String id;
    private String descripcion;
    private Integer estado;

    public Enfermedad(String id, String descripcion, Integer estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}
