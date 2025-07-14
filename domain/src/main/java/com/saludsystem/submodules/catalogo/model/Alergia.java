package com.saludsystem.submodules.catalogo.model;

import java.util.UUID;

public class Alergia {
    private UUID id;
    private String nombre;
    private Integer estado;

    public Alergia(UUID id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public UUID setId(UUID id) {
        return this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {
        return this.nombre = nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public Integer setEstado(Integer estado) {
        return this.estado = estado;
    }

}