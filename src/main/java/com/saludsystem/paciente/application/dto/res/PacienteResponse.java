package com.saludsystem.paciente.application.dto.res;

import com.saludsystem.paciente.application.dto.base.PacienteBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class PacienteResponse extends PacienteBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}