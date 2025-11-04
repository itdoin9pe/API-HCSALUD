package com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta;

import java.time.LocalDateTime;
import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InformeInterconsultaEditCommand extends BaseDTO
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
