package com.saludsystem.submodules.configuracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Sede {
    private UUID id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    private Integer estado;
    private UUID sucursalId;
}