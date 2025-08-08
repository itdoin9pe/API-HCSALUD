package com.saludsystem.submodules.catalogo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecialidadDTO {

    private UUID especialidadId;

    private String nombre;

    private String descripcion;

    @Schema(description = "Estado de Especialidades (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}