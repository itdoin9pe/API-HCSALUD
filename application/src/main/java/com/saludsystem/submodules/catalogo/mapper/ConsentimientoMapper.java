package com.saludsystem.submodules.catalogo.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ConsentimientoEditCommand;

public class ConsentimientoMapper
{
	public Consentimiento fromCreateDto(ConsentimientoCreateCommand dto)
	{
		return new Consentimiento(null, dto.getNombre(), dto.getObservacion(), dto.getEstado(), dto.getTexto());
	}

	public Consentimiento fromUpdateDto(UUID uuid, ConsentimientoEditCommand dto)
	{
		return new Consentimiento(uuid, dto.getNombre(), dto.getObservacion(), dto.getEstado(), dto.getTexto());
	}

	public ConsentimientoDTO toDto(Consentimiento model)
	{
		return new ConsentimientoDTO(model.getId(), model.getTexto(), model.getNombre(), model.getObservacion(),
				model.getEstado());
	}
}