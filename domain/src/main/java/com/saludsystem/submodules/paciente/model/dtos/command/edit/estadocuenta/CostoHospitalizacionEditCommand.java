package com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CostoHospitalizacionEditCommand extends BaseDTO
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