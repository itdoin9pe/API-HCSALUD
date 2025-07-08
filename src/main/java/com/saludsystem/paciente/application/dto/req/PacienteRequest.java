package com.saludsystem.paciente.application.dto.req;

import com.saludsystem.paciente.application.dto.base.PacienteBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class PacienteRequest extends PacienteBaseDTO {
    private UUID pacienteId;
}