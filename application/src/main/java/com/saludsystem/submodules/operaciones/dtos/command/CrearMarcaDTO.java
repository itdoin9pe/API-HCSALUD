package com.saludsystem.submodules.operaciones.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearMarcaDTO {

    private String nombre;

    @Schema(description = "Estado de marca", example = "0")
    private Integer estado;

}