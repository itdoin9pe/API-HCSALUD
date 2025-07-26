package com.saludsystem.submodules.principal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class InformacionClinica {

    private UUID id;
    private String nombre;
    private Integer estado;

}
