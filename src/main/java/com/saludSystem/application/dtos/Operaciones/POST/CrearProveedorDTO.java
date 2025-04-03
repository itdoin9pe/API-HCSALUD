package com.saludSystem.application.dtos.Operaciones.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearProveedorDTO {

    private String ruc;

    @Schema(description = "qDhvZULMGjKAedzNwdna")
    private String nombre;

    private String direccion;

    private String telefono;

    @Schema(description = "user@example.com")
    private String correo;

    private String contacto;

}