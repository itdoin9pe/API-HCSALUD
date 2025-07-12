package com.saludsystem.domain.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Consentimiento {
    private UUID id;
    private String nombre;
    private String observacion;
    private Integer estado;
    private String texto;
}