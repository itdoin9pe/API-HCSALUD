package com.saludsystem.submodules.catalogo.dto;

import com.saludsystem.submodules.catalogo.dto.command.CrearPlanDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanDTO extends CrearPlanDTO {
    private UUID planId;

    public PlanDTO(UUID id, String nombrePlan, LocalDate fechaInicio, LocalDate fechaFinContrato, int maxPlan, int useMax, Double costoPlan, Integer estado) {
        this.setPlanId(id);
        this.setNombrePlan(nombrePlan);
        this.setFechaInicio(fechaInicio);
        this.setFechaFinContrato(fechaFinContrato);
        this.setMaxPlan(maxPlan);
        this.setUseMax(useMax);
        this.setEstado(estado);
    }
}