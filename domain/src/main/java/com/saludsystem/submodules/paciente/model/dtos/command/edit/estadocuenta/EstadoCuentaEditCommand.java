package com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta;

import java.util.Date;
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
public class EstadoCuentaEditCommand extends BaseDTO
{
	private UUID pacEstadoCuentaId;
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