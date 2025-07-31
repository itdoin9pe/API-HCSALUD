package com.saludsystem.submodules.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Apoderado {

    private UUID id;
    private String nombre;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private Integer estado;

}