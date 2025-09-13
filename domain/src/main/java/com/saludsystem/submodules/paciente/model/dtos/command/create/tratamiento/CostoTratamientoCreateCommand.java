package com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CostoTratamientoCreateCommand
{
	private UUID pacienteId;
	private UUID pacientePlanTratamientoId;
	private String concepto;

	@Schema(description = "Monto del costo para traatamiento para pacientes", example = "0")
	private double monto;

	private String moneda;

	@Schema(description = "Estado del costo", example = "0")
	private boolean pagado;
}