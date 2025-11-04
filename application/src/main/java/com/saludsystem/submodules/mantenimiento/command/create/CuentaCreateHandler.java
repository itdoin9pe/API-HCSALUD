package com.saludsystem.submodules.mantenimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.CuentaCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaCreateService;

@Component
public class CuentaCreateHandler
{
	private final CuentaCreateService cuentaCreateService;
	private final CuentaMapper cuentaMapper;

	public CuentaCreateHandler(CuentaCreateService cuentaCreateService, CuentaMapper cuentaMapper)
	{
		this.cuentaCreateService = cuentaCreateService;
		this.cuentaMapper = cuentaMapper;
	}

	public void execute(CuentaCreateCommand createCommand)
	{
		var cuenta = cuentaMapper.fromCreateDto(createCommand);
		cuentaCreateService.execute(cuenta);
	}
}