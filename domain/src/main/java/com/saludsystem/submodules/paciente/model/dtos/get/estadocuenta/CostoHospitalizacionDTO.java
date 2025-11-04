package com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CostoHospitalizacionDTO
{
	private UUID pecCostoHospitalizacionId;

	private UUID pacEstadoCuentaId;

	private UUID pacienteId;

	private LocalDate fechaIngreso;

	private LocalDate fechaAlta;

	private String tipoHabitacion;

	@Schema(example = "0")
	private Double costoPorDia;

	@Schema(example = "Integer")
	private Integer cantidadDias;

	@Schema(example = "0")
	private Double totalCosto;
}