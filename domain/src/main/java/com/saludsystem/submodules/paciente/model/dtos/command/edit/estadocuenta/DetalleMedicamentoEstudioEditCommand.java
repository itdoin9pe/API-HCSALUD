package com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta;

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
public class DetalleMedicamentoEstudioEditCommand extends BaseDTO
{
	private UUID pacDetalleMedicamentoId;
	private UUID pacienteId;
	private UUID estadoCuentaId;
	private String tipo;
	private String descripcion;

	@Schema(example = "0")
	private Integer cantidad;

	@Schema(example = "0")
	private Double costoUnitario;

	@Schema(example = "0")
	private Double totalCosto;
}
