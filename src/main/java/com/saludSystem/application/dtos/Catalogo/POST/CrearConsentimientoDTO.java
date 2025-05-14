package com.saludSystem.application.dtos.Catalogo.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearConsentimientoDTO {

    private String nombre;

    private String observacion;

    private String texto;

    @Schema(description = "estado del consentimiento", example = "0")
    private Integer estado;

}