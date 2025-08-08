package com.saludsystem.submodules.operaciones.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProveedorCreateCommand {

    private String ruc;

    @Schema(description = "qDhvZULMGjKAedzNwdna")
    private String nombre;

    private String direccion;

    private String telefono;

    @Schema(description = "user@example.com")
    private String correo;

    private String contacto;

}