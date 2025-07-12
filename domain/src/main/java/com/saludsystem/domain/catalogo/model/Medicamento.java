package com.saludsystem.domain.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Medicamento {
    private UUID id;
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    private Integer estado;
}