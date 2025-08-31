package com.saludsystem.submodules.paciente.model.entity.interconsulta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Interconsulta {
	private UUID pacienteInterconsultaId;
	private UUID pacienteId;
	private UUID medicoSolicitante;
	private UUID especialidadDestino;
	private String motivo;
	private LocalDateTime fechaSolicitud;
	private String estado;
	private String prioridad;
	private String observaciones;
	private LocalDateTime fechaAtencion;

	public Interconsulta(UUID pacienteInterconsultaId, UUID pacienteId, UUID medicoSolicitante,
			UUID especialidadDestino, String motivo, LocalDateTime fechaSolicitud, String estado, String prioridad,
			String observaciones, LocalDateTime fechaAtencion) {
		this.pacienteInterconsultaId = pacienteInterconsultaId;
		this.pacienteId = pacienteId;
		this.medicoSolicitante = medicoSolicitante;
		this.especialidadDestino = especialidadDestino;
		this.motivo = motivo;
		this.fechaSolicitud = fechaSolicitud;
		this.estado = estado;
		this.prioridad = prioridad;
		this.observaciones = observaciones;
		this.fechaAtencion = fechaAtencion;
	}
}