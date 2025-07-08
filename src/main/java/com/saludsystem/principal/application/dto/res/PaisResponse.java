package com.saludsystem.principal.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PaisResponse {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer paisId;

    private String iso;

    private String nombre;

    private String gentilicio;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0")
    private Integer orden;

}