package com.saludsystem.submodules.catalogo.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadCreateService;

@Component
public class EspecialidadCreateHandler
{
	private final EspecialidadCreateService especialidadCreateService;
	private final EspecialidadMapper especialidadMapper;

	public EspecialidadCreateHandler(
		EspecialidadCreateService especialidadCreateService,
		EspecialidadMapper especialidadMapper)
	{
		this.especialidadCreateService = especialidadCreateService;
		this.especialidadMapper = especialidadMapper;
	}

	public void execute(EspecialidadCreateCommand createCommand)
	{
		var especialidad = especialidadMapper.fromCreateDto(createCommand);
		especialidadCreateService.execute(especialidad);
	}
}