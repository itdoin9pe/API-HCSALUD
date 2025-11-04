package com.saludsystem.submodules.paciente.model.entity.interconsulta;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class InformeInterconsulta {
	private UUID pacienteInformeInterconsultaId;
	private UUID pacienteInterconsultaId;
	private UUID medicoResponsable;
	private LocalDateTime fecha;
	private String resumenClinico;
	private String diagnostico;
	private String recomendaciones;
	private String archivoAdjuntoUrl;

	public InformeInterconsulta(UUID pacienteInformeInterconsultaId, UUID pacienteInterconsultaId,
			UUID medicoResponsable, LocalDateTime fecha, String resumenClinico, String diagnostico,
			String recomendaciones, String archivoAdjuntoUrl) {
		this.pacienteInformeInterconsultaId = pacienteInformeInterconsultaId;
		this.pacienteInterconsultaId = pacienteInterconsultaId;
		this.medicoResponsable = medicoResponsable;
		this.fecha = fecha;
		this.resumenClinico = resumenClinico;
		this.diagnostico = diagnostico;
		this.recomendaciones = recomendaciones;
		this.archivoAdjuntoUrl = archivoAdjuntoUrl;
	}
}