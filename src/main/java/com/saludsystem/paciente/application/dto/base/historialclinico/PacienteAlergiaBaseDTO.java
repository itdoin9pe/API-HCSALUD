package com.saludsystem.paciente.application.dto.base.historialclinico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public abstract class PacienteAlergiaBaseDTO {
    private UUID pacienteId;

    private UUID alergiaId;

    private String observacion;

    @Schema(example = "0")
    private Integer estado;
}
