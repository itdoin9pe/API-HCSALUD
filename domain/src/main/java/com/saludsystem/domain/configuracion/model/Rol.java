package com.saludsystem.domain.configuracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Rol {
    private UUID roleId;
    private Integer estado;
    private String nombre;
}
