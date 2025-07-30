package com.saludsystem.submodules.operaciones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Marca {

    private UUID id;
    private String nombre;
    private Integer estado;

}
