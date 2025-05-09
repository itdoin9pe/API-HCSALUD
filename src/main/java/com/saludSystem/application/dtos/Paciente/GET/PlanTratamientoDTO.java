package com.saludSystem.application.dtos.Paciente.GET;

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