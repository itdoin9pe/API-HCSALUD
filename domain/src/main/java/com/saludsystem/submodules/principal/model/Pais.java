package com.saludsystem.submodules.principal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pais {

    private Integer id;
    private String iso;
    private String nombre;
    private String gentilicio;
    private Integer orden;

}
