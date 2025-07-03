package com.saludsystem.application.dtos.operaciones.get;

import lombok.Data;
import java.util.UUID;

@Data
public class ProveedorDTO {

    private UUID proveedorId;

    private String ruc;

    private String nombre;

    private String direccion;

    private String telefono;

    private String correo;

    private String contacto;

}