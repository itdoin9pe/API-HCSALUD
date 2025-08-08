package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaisDTO {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer paisId;

    private String iso;

    private String nombre;

    private String gentilicio;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer orden;

}