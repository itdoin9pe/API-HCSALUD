package com.saludsystem.paciente.application.dto.res.historialclinico.evolucion;

import com.saludsystem.paciente.application.dto.base.historialclinico.evolucion.AltaMedicaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class AltaMedicaResponse extends AltaMedicaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}