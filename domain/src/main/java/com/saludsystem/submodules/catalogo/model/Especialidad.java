package com.saludsystem.submodules.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Especialidad {
    private UUID id;
    private String nombre;
    private String descripcion;
    private Integer estado;
    private UUID hospitalId;
    private UUID userId;

    public Especialidad(UUID id, String nombre, String descripcion, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Especialidad() {

    }
}
