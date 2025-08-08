package com.saludsystem.submodules.operaciones.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarcaDTO {

    private UUID marcaId;

    private String nombre;

    @Schema(description = "Estado de marca", example = "0")
    private Integer estado;

}