package com.saludsystem.operaciones.application.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class UnidadResponse {

    private UUID unidadId;

    private String nombre;

    private String siglas;

    private String descripcion;

    @Schema(description = "estado de la unidad", example = "0")
    private Integer estado;

}