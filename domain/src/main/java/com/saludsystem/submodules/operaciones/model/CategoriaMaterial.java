package com.saludsystem.submodules.operaciones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CategoriaMaterial {

    private UUID categoriaMaterialId;
    private String nombre;
    private String descripcion;
    private Integer estado;

}
