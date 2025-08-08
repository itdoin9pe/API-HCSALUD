package com.saludsystem.submodules.operaciones.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PresentacionDTO {

    private UUID presentacionId;

    private String nombre;

    @Schema(description = "Estado de presentacion", example = "0")
    private Integer estado;

}