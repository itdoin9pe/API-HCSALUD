package com.saludsystem.paciente.application.dto.base.historialclinico.evolucion;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class AltaMedicaBaseDTO {
    private LocalDateTime fecha;
    private String resumenFinal;
    private UUID pacienteEvolucionId;
}