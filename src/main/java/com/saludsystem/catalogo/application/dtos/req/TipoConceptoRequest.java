package com.saludsystem.catalogo.application.dtos.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TipoConceptoRequest {

    private String nombre;

    @Schema(description = "Estado del Tipo Concepto (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}