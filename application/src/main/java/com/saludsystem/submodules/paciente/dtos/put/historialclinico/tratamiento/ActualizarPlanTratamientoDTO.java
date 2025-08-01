package com.saludsystem.submodules.paciente.dtos.put.historialclinico.tratamiento;

import com.saludsystem.submodules.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarPlanTratamientoDTO extends BaseDTO {

    private UUID pacientePlanTratamientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
