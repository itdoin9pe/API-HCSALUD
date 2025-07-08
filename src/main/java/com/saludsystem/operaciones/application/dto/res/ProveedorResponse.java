package com.saludsystem.operaciones.application.dto.res;

import lombok.Data;
import java.util.UUID;

@Data
public class ProveedorResponse {

    private UUID proveedorId;

    private String ruc;

    private String nombre;

    private String direccion;

    private String telefono;

    private String correo;

    private String contacto;

}