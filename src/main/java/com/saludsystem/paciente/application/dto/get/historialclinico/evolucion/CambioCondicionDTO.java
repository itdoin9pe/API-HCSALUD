package com.saludsystem.paciente.application.dto.get.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CambioCondicionDTO extends CrearCambioCondicionDTO {
    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;
}