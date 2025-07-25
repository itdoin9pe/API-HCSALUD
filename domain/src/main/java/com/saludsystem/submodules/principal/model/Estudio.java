package com.saludsystem.submodules.principal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Estudio {

    private UUID id;
    private String descripcion;

}