package com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento;

import lombok.Data;

import java.util.UUID;

@Data
public class PlanTratamientoResponse {
    private UUID hospitalId;
    private UUID userId;
}