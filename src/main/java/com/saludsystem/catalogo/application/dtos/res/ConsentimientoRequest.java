package com.saludsystem.catalogo.application.dtos.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ConsentimientoRequest {

    private UUID consentimientoId;

    private String nombre;

    private String observacion;

    private String texto;

    @Schema(description = "estado del consentimiento", example = "0")
    private Integer estado;

}