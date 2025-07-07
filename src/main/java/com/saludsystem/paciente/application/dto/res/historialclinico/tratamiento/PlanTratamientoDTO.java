package com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class PlanTratamientoDTO {

    private UUID pacientePlanTratamientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}