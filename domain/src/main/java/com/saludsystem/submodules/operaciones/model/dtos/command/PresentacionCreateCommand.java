package com.saludsystem.submodules.operaciones.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PresentacionCreateCommand {

    private String nombre;

    @Schema(description = "Estado de presentacion", example = "0")
    private Integer estado;

}