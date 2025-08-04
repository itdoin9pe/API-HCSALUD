package com.saludsystem.submodules.operaciones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Unidad {

    private UUID unidadId;
    private String nombre;
    private String siglas;
    private String descripcion;
    private Integer estado;

}
