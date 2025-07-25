package com.saludsystem.submodules.principal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Empresa {
    private UUID empresaId;
    private String descripcion;
    private Integer estado;
}
