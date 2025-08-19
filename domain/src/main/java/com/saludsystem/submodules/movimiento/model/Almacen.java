package com.saludsystem.submodules.movimiento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Almacen {

    private UUID almacenId;
    private String nombre;
    private Integer estado;

    private UUID sedeId;
    private UUID sucursalId;

}
