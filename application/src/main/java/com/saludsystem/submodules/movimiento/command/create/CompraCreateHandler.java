package com.saludsystem.submodules.movimiento.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.CompraMapper;
import com.saludsystem.submodules.movimiento.model.dtos.command.CompraCreateCommand;
import com.saludsystem.submodules.movimiento.service.compra.CompraCreateService;

@Component
public class CompraCreateHandler
{
	private final CompraCreateService compraCreateService;
	private final CompraMapper compraMapper;

	public CompraCreateHandler(CompraCreateService compraCreateService, CompraMapper compraMapper)
	{
		this.compraCreateService = compraCreateService;
		this.compraMapper = compraMapper;
	}

	public void execute(CompraCreateCommand createCommand)
	{
		var compraSaved = compraMapper.fromCreateDto(createCommand);
		compraCreateService.execute(compraSaved);
	}
}