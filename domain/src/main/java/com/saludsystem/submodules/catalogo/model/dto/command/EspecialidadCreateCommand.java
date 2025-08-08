package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecialidadCreateCommand {
    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}