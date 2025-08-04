package com.saludsystem.submodules.operaciones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Presentacion {

    private UUID id;

    private String nombre;

    private Integer estado;

}
