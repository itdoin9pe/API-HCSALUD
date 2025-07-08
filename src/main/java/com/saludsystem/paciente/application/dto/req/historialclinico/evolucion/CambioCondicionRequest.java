package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.CambioCondicionBaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CambioCondicionRequest extends CambioCondicionBaseDTO {
    @Schema(example = "Integer")
    private Long evolucionCambioCondicionId;
}