package com.saludSystem.application.dtos.Operaciones.PUT;

import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarProveedorDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID proveedorId;

    private String ruc;

    private String nombre;

    private String direccion;

    private String telefono;

    private String correo;

    private String contacto;

}