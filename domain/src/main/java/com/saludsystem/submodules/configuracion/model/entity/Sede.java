package com.saludsystem.submodules.configuracion.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
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