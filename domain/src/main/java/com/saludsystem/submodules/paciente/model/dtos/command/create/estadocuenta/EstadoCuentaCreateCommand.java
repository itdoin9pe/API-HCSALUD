package com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta;

import java.util.Date;
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
public class EstadoCuentaCreateCommand
{
	private UUID pacienteId;

	private Date fechaApertura;

	private String estado;

	@Schema(example = "0")
	private Double totalHospitalizacion;

	@Schema(example = "0")
	private Double totalMedicamentosEstudios;

	@Schema(example = "0")
	private Double totalPagado;

	@Schema(example = "0")
	private Double saldoPendiente;
}