package com.saludsystem.submodules.paciente.model.dtos.get.interconsulta;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InformeInterconsultaDTO
{
	private UUID pacienteInformeInterconsultaId;
	private UUID pacienteInterconsultaId;
	private UUID medicoResponsable;
	private LocalDateTime fecha;
	private String resumenClinico;
	private String diagnostico;
	private String recomendaciones;
	private String archivoAdjuntoUrl;
}
