package com.saludsystem.submodules.operaciones.command.edit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.PresentacionMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.PresentacionEditCommand;
import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionEditService;

@Component
public class PresentacionEditHandler
{
	private final PresentacionEditService presentacionEditService;
	private final PresentacionMapper presentacionMapper;

	public PresentacionEditHandler(
		PresentacionEditService presentacionEditService,
		PresentacionMapper presentacionMapper)
	{
		this.presentacionEditService = presentacionEditService;
		this.presentacionMapper = presentacionMapper;
	}

	public void execute(UUID uuid, PresentacionEditCommand editCommand)
	{
		var presentacion = presentacionMapper.fromUpdateDto(uuid, editCommand);
		presentacionEditService.execute(uuid, presentacion);
	}
}