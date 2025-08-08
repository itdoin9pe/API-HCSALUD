package com.saludsystem.submodules.movimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlmacenDTO {

    private UUID almacenId;
    
    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;

	private UUID sedeId;

	private UUID sucursalId;
    
}