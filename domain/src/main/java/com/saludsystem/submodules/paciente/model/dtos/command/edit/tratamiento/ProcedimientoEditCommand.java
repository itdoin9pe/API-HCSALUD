package com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento;

import java.time.LocalDate;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;
import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;

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
public class ProcedimientoEditCommand extends BaseDTO
{
	private UUID pacienteProcedimientoId;
	private UUID pacienteId;
	private UUID doctorId;
	private TipoProcedimiento tipoProcedimiento;
	private String descripcion;
	private LocalDate fecha;
	private String resultado;
}
