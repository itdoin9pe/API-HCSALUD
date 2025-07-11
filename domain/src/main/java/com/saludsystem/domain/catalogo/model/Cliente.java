package com.saludsystem.domain.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Cliente {
    private UUID id;
    private String tipoDocumento;
    private String nombre;
    private String direccion;
    private String contacto;
    private String telefono;
    private String email;
    private Integer estado;
}
