package com.saludsystem.application.dtos.paciente.put.tratamiento;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarPlanTratamientoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacientePlanTratamientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}