package com.saludsystem.submodules.paciente.dtos.put.historialclinico.tratamiento;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarCostoTratamientoDTO extends BaseDTO {

    private UUID pacienteId;

    private UUID pacientePlanTratamientoId;

    private String concepto;

    @Schema(description = "Monto del costo para traatamiento para pacientes", example = "0")
    private double monto;

    private String moneda;

    @Schema(description = "Estado del costo", example = "0")
    private boolean pagado;
}
