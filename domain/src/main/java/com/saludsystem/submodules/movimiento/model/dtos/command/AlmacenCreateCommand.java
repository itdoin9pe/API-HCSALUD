package com.saludsystem.submodules.movimiento.model.dtos.command;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlmacenCreateCommand {

    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;
    
    private UUID sedeId;
    
    private UUID sucursalId;

}