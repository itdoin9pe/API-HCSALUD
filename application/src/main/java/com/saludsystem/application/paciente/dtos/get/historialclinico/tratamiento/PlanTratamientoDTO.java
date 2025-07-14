package com.saludsystem.application.paciente.dtos.get.historialclinico.tratamiento;

import com.saludsystem.application.paciente.dtos.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanTratamientoDTO extends CrearPlanTratamientoDTO {
    private UUID pacientePlanTratamientoId;
}