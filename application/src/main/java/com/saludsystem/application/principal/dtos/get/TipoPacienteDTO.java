package com.saludsystem.application.principal.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPacienteDTO {

    @Schema(description = "Estado del país (0 = inactivo, 1 = activo)", example = "1", type = "integer", defaultValue = "0")
    private Integer tipoPacienteId;

    private String nombre;

}