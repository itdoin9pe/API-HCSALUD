package com.saludsystem.submodules.principal.mapper;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.model.dtos.EmpresaDTO;
import com.saludsystem.submodules.principal.model.dtos.command.EmpresaCreateCommand;
import com.saludsystem.submodules.principal.model.dtos.command.edit.EmpresaEditCommand;

public class EmpresaMapper
{
	public Empresa fromCreateDto(EmpresaCreateCommand dto)
	{
		return new Empresa(null, dto.getDescripcion(), dto.getEstado());
	}

	public Empresa fromUpdateDto(UUID uuid, EmpresaEditCommand dto)
	{
		return new Empresa(uuid, dto.getDescripcion(), dto.getEstado());
	}

	public EmpresaDTO toDto(Empresa model)
	{
		return new EmpresaDTO(model.getEmpresaId(), model.getDescripcion(), model.getEstado());
	}
}