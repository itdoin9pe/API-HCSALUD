package com.saludsystem.submodules.catalogo.dto.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarPlanDTO extends BaseDTO {
    private UUID planId;
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