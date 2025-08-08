package com.saludsystem.submodules.operaciones.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProveedorDTO {

    private UUID proveedorId;

    private String ruc;

    @Schema(description = "qDhvZULMGjKAedzNwdna")
    private String nombre;

    private String direccion;

    private String telefono;

    @Schema(description = "user@example.com")
    private String correo;

    private String contacto;

}