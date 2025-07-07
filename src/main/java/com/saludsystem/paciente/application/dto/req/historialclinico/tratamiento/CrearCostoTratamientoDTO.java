package com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class CrearCostoTratamientoDTO {

    private UUID pacienteId;

    private UUID pacientePlanTratamientoId;

    private String concepto;

    @Schema(description = "Monto del costo para traatamiento para pacientes", example = "0")
    private double monto;

    private String moneda;

    @Schema(description = "Estado del costo", example = "0")
    private boolean pagado;

}