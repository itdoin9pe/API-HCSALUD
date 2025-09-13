package com.saludsystem.submodules.movimiento.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.model.constant.InventarioConstant;
import com.saludsystem.submodules.movimiento.model.dtos.InventarioDTO;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;

@Component
public class InventarioByIdHandler
{
	private final InventarioDao inventarioDao;
	private final InventarioMapper inventarioMapper;

	/**
	 * @param inventarioDao
	 * @param inventarioMapper
	 */
	public InventarioByIdHandler(InventarioDao inventarioDao, InventarioMapper inventarioMapper)
	{
		this.inventarioDao = inventarioDao;
		this.inventarioMapper = inventarioMapper;
	}

	public InventarioDTO execute(UUID uuid)
	{
		var inventario = inventarioDao.getById(uuid);
		if (inventario == null)
		{
			throw new IllegalArgumentException(InventarioConstant.INVALID_ID);
		}
		return inventarioMapper.toDto(inventario);
	}
}