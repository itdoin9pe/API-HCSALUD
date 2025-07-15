package com.saludsystem.submodules.configuracion.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class SysSalud {
    private UUID id;
    private String nombre;
    private String direccion;
    private String celular;
    private String email;
    private String ruc;
    private LocalDate fecha;
    private String foto;
    private Integer estado;
    private UUID planId;
}