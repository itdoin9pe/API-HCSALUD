package com.saludSystem.application.dtos.Generals.Pais;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearPaisDTO {

    private String iso;

    private String nombre;

    private String gentilicio;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer orden;

}