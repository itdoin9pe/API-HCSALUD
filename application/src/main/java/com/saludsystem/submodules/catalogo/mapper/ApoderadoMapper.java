package com.saludsystem.submodules.catalogo.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ApoderadoEditCommand;

public class ApoderadoMapper
{
	public Apoderado fromCreateDto(ApoderadoCreateCommand dto)
	{
		return new Apoderado(null, dto.getNombre(), dto.getDireccion(), dto.getTipoDocumento(), dto.getNroDocumento(),
				dto.getTelefono(), dto.getEstado());
	}

	public Apoderado fromUpdateDto(UUID id, ApoderadoEditCommand dto)
	{
		return new Apoderado(id, dto.getNombre(), dto.getDireccion(), dto.getTipoDocumento(), dto.getNroDocumento(),
				dto.getTelefono(), dto.getEstado());
	}

	public ApoderadoDTO toDto(Apoderado model)
	{
		return new ApoderadoDTO(model.getId(), model.getNombre(), model.getDireccion(), model.getTipoDocumento(),
				model.getNroDocumento(), model.getTelefono(), model.getEstado());
	}
}