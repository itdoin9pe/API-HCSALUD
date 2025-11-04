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
public class InterconsultaEditCommand extends BaseDTO
{
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
}
