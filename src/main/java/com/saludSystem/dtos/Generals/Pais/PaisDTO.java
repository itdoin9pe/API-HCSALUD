package com.saludSystem.dtos.Generals.Pais;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PaisDTO {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer", defaultValue = "0")
    private Integer paisId;

    private String iso;

    private String nombre;

    private String gentilicio;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer orden;

}