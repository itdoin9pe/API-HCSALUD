package com.saludsystem.submodules.paciente.mapper.historialclinico.tratamiento;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PlanTratamientoMapper {

    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}