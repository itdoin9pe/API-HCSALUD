package com.saludsystem.submodules.catalogo.model.dto.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CrearPlanDTO {
    private String nombrePlan;
    private LocalDate fechaInicio;
    private LocalDate fechaFinContrato;
    @Schema(description = "Estado del Plan (0 = inactivo, 1 = activo)", example = "0")
    private int maxPlan;
    @Schema(description = "Estado del Plan (0 = inactivo, 1 = activo)", example = "0")
    private int useMax;
    @Schema(description = "Estado del Plan (0 = inactivo, 1 = activo)", example = "0")
    private Double costoPlan;
    @Schema(description = "Estado del Plan (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}