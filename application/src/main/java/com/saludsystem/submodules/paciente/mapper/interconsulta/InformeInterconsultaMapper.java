package com.saludsystem.submodules.paciente.mapper.interconsulta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta.InformeInterconsultaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta.InformeInterconsultaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InformeInterconsultaDTO;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;

public class InformeInterconsultaMapper
{
	public InformeInterconsulta fromCreateDto(InformeInterconsultaCreateCommand createCommand)
	{
		return new InformeInterconsulta(null, createCommand.getPacienteInterconsultaId(),
				createCommand.getMedicoResponsable(), createCommand.getFecha(), createCommand.getResumenClinico(),
				createCommand.getDiagnostico(), createCommand.getRecomendaciones(),
				createCommand.getArchivoAdjuntoUrl());
	}

	public InformeInterconsulta fromUpdateDto(UUID uuid, InformeInterconsultaEditCommand editCommand)
	{
		return new InformeInterconsulta(uuid, editCommand.getPacienteInterconsultaId(),
				editCommand.getMedicoResponsable(), editCommand.getFecha(), editCommand.getResumenClinico(),
				editCommand.getDiagnostico(), editCommand.getRecomendaciones(), editCommand.getArchivoAdjuntoUrl());
	}

	public InformeInterconsultaDTO toDto(InformeInterconsulta model)
	{
		return new InformeInterconsultaDTO(model.getPacienteInformeInterconsultaId(),
				model.getPacienteInterconsultaId(), model.getMedicoResponsable(), model.getFecha(),
				model.getResumenClinico(), model.getDiagnostico(), model.getRecomendaciones(),
				model.getArchivoAdjuntoUrl());
	}
}