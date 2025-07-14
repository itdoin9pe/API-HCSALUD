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
}
