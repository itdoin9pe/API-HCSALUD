package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanTratamientoDTO extends CrearPlanTratamientoDTO {
    private UUID pacientePlanTratamientoId;
}