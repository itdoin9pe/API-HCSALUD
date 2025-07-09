package com.saludsystem.operaciones.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarProveedorDTO extends BaseDTO {

    private UUID proveedorId;

    private String ruc;

    private String nombre;

    private String direccion;

    private String telefono;

    private String correo;

    private String contacto;
}
