package com.saludsystem.paciente.application.dto.req.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.NotaBaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NotaRequest extends NotaBaseDTO {
    @Schema(description = "ID de la evolucion del paciente", example = "Integer")
    private Long pacienteEvolucionNotaId;
}