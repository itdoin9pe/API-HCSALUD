package com.saludsystem.submodules.paciente.dtos.get.historialclinico.evolucion;

import com.saludsystem.submodules.paciente.dtos.post.historialclinico.evolucion.CrearNotaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NotaDTO extends CrearNotaDTO {
    @Schema(description = "ID de la evolucion del paciente", example = "Integer")
    private Long pacienteEvolucionNotaId;
}