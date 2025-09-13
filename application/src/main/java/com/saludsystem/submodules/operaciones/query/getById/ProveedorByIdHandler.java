package com.saludsystem.submodules.operaciones.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.operaciones.mapper.ProveedorMapper;
import com.saludsystem.submodules.operaciones.model.constant.ProveedorConstant;
import com.saludsystem.submodules.operaciones.model.dtos.ProveedorDTO;
import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;

@Component
public class ProveedorByIdHandler
{
	private final ProveedorDao proveedorDao;
	private final ProveedorMapper proveedorMapper;

	public ProveedorByIdHandler(ProveedorDao proveedorDao, ProveedorMapper proveedorMapper)
	{
		this.proveedorDao = proveedorDao;
		this.proveedorMapper = proveedorMapper;
	}

	public ProveedorDTO execute(UUID uuid)
	{
		var proveedor = proveedorDao.getById(uuid);
		if (proveedor == null)
		{
			throw new IllegalArgumentException(ProveedorConstant.INVALID_ID);
		}
		return proveedorMapper.toDto(proveedor);
	}
}