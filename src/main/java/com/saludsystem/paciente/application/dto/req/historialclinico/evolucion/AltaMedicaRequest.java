package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.AltaMedicaBaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class AltaMedicaRequest extends AltaMedicaBaseDTO {
    @Schema(example = "Integer")
    private Long evolucionAltaMedicaId;
}