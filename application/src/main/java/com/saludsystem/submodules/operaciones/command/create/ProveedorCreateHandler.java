package com.saludsystem.submodules.operaciones.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProveedorMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.ProveedorCreateCommand;
import com.saludsystem.submodules.operaciones.service.proveedor.ProveedorCreateService;

@Component
public class ProveedorCreateHandler
{
	private final ProveedorCreateService proveedorCreateService;
	private final ProveedorMapper proveedorMapper;

	public ProveedorCreateHandler(ProveedorCreateService proveedorCreateService, ProveedorMapper proveedorMapper)
	{
		this.proveedorCreateService = proveedorCreateService;
		this.proveedorMapper = proveedorMapper;
	}

	public void execute(ProveedorCreateCommand createCommand)
	{
		var proveedor = proveedorMapper.fromCreateDto(createCommand);
		proveedorCreateService.execute(proveedor);
	}
}