package com.saludsystem.paciente.application.dto.req.historialclinico;

import com.saludsystem.paciente.application.dto.base.historialclinico.PacienteAlergiaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class PacienteAlergiaRequest extends PacienteAlergiaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}