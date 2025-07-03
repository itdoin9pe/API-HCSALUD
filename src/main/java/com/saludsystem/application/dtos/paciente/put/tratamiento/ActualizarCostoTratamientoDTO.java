package com.saludsystem.application.dtos.paciente.put.tratamiento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarCostoTratamientoDTO {

    private UUID hospitalId;

    private UUID userId;

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