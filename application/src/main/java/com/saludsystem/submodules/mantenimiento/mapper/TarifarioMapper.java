package com.saludsystem.submodules.mantenimiento.mapper;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TarifarioCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TarifarioEditCommand;

public class TarifarioMapper
{
	public Tarifario fromCreateDto(TarifarioCreateCommand createCommand)
	{
		return new Tarifario(null, createCommand.getTipoConceptoId(), createCommand.getCategoriaId(),
				createCommand.getMedidaId(), createCommand.getUnidadId(), createCommand.getGrupo(),
				createCommand.getDescripcion(), createCommand.getPrecio(), createCommand.getEstado());
	}

	public Tarifario fromUpdateDto(UUID uuid, TarifarioEditCommand editCommand)
	{
		return new Tarifario(uuid, editCommand.getTipoConceptoId(), editCommand.getCategoriaId(),
				editCommand.getMedidaId(), editCommand.getUnidadId(), editCommand.getGrupo(),
				editCommand.getDescripcion(), editCommand.getPrecio(), editCommand.getEstado());
	}

	public TarifarioDTO toDto(Tarifario model)
	{
		return new TarifarioDTO(model.getId(), model.getTipoConceptoId(), model.getCategoriaId(), model.getMedidaId(),
				model.getUnidadId(), model.getGrupo(), model.getDescripcion(), model.getPrecio(), model.getEstado());
	}
}