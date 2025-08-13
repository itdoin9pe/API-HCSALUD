package com.saludsystem.submodules.configuracion.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SedeCreateCommand {
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    @Schema(description = "Estado de la sede (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

    private UUID sucursalId;
}