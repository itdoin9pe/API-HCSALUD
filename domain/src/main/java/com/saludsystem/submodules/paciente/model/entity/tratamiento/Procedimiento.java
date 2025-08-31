package com.saludsystem.submodules.paciente.model.entity.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.TipoProcedimiento;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Procedimiento {
	private UUID procedimientoId;
	private UUID pacienteId;
	private UUID doctorId;
	private TipoProcedimiento tipoProcedimiento;
	private String descripcion;
	private LocalDate fecha;
	private String resultado;

	public Procedimiento(UUID procedimientoId, UUID pacienteId, UUID doctorId, TipoProcedimiento tipoProcedimiento,
			String descripcion, LocalDate fecha, String resultado) {
		this.procedimientoId = procedimientoId;
		this.pacienteId = pacienteId;
		this.doctorId = doctorId;
		this.tipoProcedimiento = tipoProcedimiento;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.resultado = resultado;
	}
}