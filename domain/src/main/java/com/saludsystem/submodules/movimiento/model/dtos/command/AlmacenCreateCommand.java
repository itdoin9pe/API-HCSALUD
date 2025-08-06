package com.saludsystem.submodules.movimiento.model.dtos.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlmacenCreateCommand {

    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;

}