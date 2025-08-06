package com.saludsystem.submodules.paciente.model.dtos.get.tratamiento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CostoTratamientoDTO {

    private UUID pacienteCostoTratamientoId;

    private UUID pacienteId;

    private UUID pacientePlanTratamientoId;

    private String concepto;

    @Schema(description = "Monto del costo para traatamiento para pacientes", example = "0")
    private double monto;

    private String moneda;

    @Schema(description = "Estado del costo", example = "0")
    private boolean pagado;

}