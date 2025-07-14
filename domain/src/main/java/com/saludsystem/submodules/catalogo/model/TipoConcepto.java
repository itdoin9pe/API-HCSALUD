package com.saludsystem.submodules.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class TipoConcepto {
    private UUID id;
    private String nombre;
    private Integer estado;
}
