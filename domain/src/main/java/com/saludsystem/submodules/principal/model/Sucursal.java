package com.saludsystem.submodules.principal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Sucursal {
    private UUID sucursalId;
    private String nombre;
    private String direccion;
    private boolean isDefault;
}
