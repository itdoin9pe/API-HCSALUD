package com.saludsystem.submodules.principal.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearPaisDTO {

    private String iso;

    private String nombre;

    private String gentilicio;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer orden;

}