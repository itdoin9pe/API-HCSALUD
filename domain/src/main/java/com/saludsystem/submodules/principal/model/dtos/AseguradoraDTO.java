package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AseguradoraDTO {

    private UUID aseguradoraId;

    private String descripcion;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

}