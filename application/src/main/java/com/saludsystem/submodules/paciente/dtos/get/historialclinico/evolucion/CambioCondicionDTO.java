package com.saludsystem.submodules.paciente.dtos.get.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.dtos.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CambioCondicionDTO extends CrearCambioCondicionDTO {
    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;
}