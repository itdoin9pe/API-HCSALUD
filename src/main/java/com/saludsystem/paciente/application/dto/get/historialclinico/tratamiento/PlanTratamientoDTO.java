package com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanTratamientoDTO extends CrearPlanTratamientoDTO {
    private UUID pacientePlanTratamientoId;
}