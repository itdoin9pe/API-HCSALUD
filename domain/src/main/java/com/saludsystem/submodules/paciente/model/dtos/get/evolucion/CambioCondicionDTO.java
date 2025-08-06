package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.command.evolucion.CrearCambioCondicionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CambioCondicionDTO extends CrearCambioCondicionDTO {
    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;
}