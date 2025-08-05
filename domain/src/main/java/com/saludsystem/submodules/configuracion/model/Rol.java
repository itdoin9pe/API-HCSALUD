package com.saludsystem.submodules.configuracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Rol {

    private UUID roleId;
    private String nombre;
    private Integer estado;

}
