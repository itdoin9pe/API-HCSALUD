package com.saludsystem.submodules.movimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AlmacenDTO {

    private UUID sedeId;

    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;

}