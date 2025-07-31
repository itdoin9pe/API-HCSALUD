package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlanDTO extends com.saludsystem.submodules.catalogo.model.dto.command.PlanCreateCommandDTO {
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