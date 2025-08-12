package com.saludsystem.submodules.paciente.model.entity.tratamiento;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class PlanTratamiento {

    private UUID pacientePlanTratamientoId;
    private UUID pacienteId;
    private UUID doctorId;
    private UUID especialidadId;
    private UUID medidaId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

}
