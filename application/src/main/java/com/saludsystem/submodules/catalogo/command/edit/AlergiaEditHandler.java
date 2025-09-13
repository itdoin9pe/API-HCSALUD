package com.saludsystem.submodules.catalogo.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.AlergiaEditCommand;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaEditService;

@Component
public class AlergiaEditHandler
{
	private final AlergiaEditService alergiaEditService;
	private final AlergiaMapper alergiaMapper;

	public AlergiaEditHandler(AlergiaEditService alergiaEditService, AlergiaMapper alergiaMapper)
	{
		this.alergiaEditService = alergiaEditService;
		this.alergiaMapper = alergiaMapper;
	}

	public void execute(UUID uuid, AlergiaEditCommand editCommand)
	{
		var alergia = alergiaMapper.fromUpdateDto(uuid, editCommand);
		alergiaEditService.execute(uuid, alergia);
	}
}