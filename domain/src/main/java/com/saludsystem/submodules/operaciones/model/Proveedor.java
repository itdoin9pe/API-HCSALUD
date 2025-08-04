package com.saludsystem.submodules.operaciones.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Proveedor {

    private UUID proveedorId;
    private String ruc;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String contacto;

}
