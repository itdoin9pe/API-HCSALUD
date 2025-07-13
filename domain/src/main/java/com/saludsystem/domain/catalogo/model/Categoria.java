package com.saludsystem.domain.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Categoria {
    private UUID id;
    private String nombre;
    private Integer estado;
}