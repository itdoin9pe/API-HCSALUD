package com.saludsystem.submodules.paciente.model.entity.tratamiento;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class PlanTratamiento {
	private UUID pacientePlanTratamientoId;
	private UUID pacienteId;
	private UUID doctorId;
	private UUID especialidadId;
	private UUID medidaId;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public PlanTratamiento(UUID pacientePlanTratamientoId, UUID pacienteId, UUID doctorId, UUID especialidadId,
			UUID medidaId, LocalDate fechaInicio, LocalDate fechaFin) {
		this.pacientePlanTratamientoId = pacientePlanTratamientoId;
		this.pacienteId = pacienteId;
		this.doctorId = doctorId;
		this.especialidadId = especialidadId;
		this.medidaId = medidaId;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
}