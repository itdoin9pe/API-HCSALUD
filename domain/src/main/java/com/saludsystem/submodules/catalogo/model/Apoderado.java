package com.saludsystem.submodules.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Apoderado {

    private UUID id;
    private String nombre;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    private Integer estado;

}