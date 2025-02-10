package com.saludSystem.dtos.catalago.Plan;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ActualizarPlanDTO{
    private UUID hospitalId;
    private UUID userId;
    private String nombrePlan;

    private Date fechaInicio;

    private Date fechaFin;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0")
    private int maxPlan;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0")
    private int useMax;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Double costoPlan;

    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;
}
