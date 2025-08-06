package com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CostoTratamientoEditCommand extends BaseDTO {

    private UUID pacienteId;

    private UUID pacientePlanTratamientoId;

    private String concepto;

    @Schema(description = "Monto del costo para traatamiento para pacientes", example = "0")
    private double monto;

    private String moneda;

    @Schema(description = "Estado del costo", example = "0")
    private boolean pagado;
}
