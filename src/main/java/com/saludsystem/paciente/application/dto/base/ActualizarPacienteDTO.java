package com.saludsystem.paciente.application.dto.base;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarPacienteDTO extends PacienteBaseDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteId;

}