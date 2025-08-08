package com.saludsystem.submodules.operaciones.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnidadCreateCommand {

    private String nombre;

    private String siglas;

    private String descripcion;

    @Schema(description = "Estado de la unidad", example = "0")
    private Integer estado;

}