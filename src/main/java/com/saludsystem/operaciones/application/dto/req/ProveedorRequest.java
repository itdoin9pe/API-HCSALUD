package com.saludsystem.operaciones.application.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProveedorRequest {

    private String ruc;

    @Schema(description = "qDhvZULMGjKAedzNwdna")
    private String nombre;

    private String direccion;

    private String telefono;

    @Schema(description = "user@example.com")
    private String correo;

    private String contacto;

}