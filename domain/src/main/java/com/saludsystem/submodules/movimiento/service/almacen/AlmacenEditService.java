package com.saludsystem.submodules.movimiento.service.almacen;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.movimiento.model.constant.AlmacenConstant;
import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;
import com.saludsystem.submodules.movimiento.port.repository.AlmacenRepository;

public class AlmacenEditService
{
	private final AlmacenDao almacenDao;
	private final AlmacenRepository almacenRepository;

	public AlmacenEditService(AlmacenDao almacenDao, AlmacenRepository almacenRepository)
	{
		this.almacenDao = almacenDao;
		this.almacenRepository = almacenRepository;
	}

	public Almacen execute(UUID uuid, Almacen almacen)
	{
		var currentAlmacen = almacenDao.getById(uuid);
		if (currentAlmacen == null)
		{
			throw new IllegalArgumentException(AlmacenConstant.ID_NOT_FOUND);
		}
		if (currentAlmacen.getEstado() != null && currentAlmacen.getEstado() == 0)
		{
			throw new IllegalStateException("El almacen ya se encuentra desactivado");
		}
		return almacenRepository.update(uuid, almacen);
	}
}
