package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApoderadoCreateCommand {
    private String nombre;
    private String nroDocumento;
    private String direccion;
    private String telefono;
    @Schema(description = "Estado de Apoderado (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}