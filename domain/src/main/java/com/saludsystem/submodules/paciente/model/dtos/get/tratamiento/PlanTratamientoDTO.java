package com.saludsystem.submodules.paciente.model.dtos.get.tratamiento;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanTratamientoDTO {

    private UUID pacientePlanTratamientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}