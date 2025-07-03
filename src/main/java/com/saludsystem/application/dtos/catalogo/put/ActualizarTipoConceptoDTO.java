package com.saludsystem.application.dtos.catalogo.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarTipoConceptoDTO {

    private UUID tipoConceptoId;

    private String nombre;

    @Schema(description = "Estado del Tipo Concepto (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}