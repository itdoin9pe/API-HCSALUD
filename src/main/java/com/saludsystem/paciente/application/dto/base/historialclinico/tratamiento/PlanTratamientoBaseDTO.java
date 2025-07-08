package com.saludsystem.paciente.application.dto.base.historialclinico.tratamiento;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public abstract class PlanTratamientoBaseDTO {
    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
