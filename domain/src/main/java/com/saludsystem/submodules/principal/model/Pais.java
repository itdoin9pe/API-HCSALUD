package com.saludsystem.submodules.principal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pais {
    private Integer id;
    private String iso;
    private String nombre;
    private String gentilicio;
    private Integer orden;

    public Pais(Integer id, String iso, String nombre, String gentilicio, Integer orden) {
    	this.id=id;
    	this.iso=iso;
    	this.nombre=nombre;
    	this.gentilicio=gentilicio;
    	this.orden=orden;
    }
}