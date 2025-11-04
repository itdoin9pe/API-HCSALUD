package com.saludsystem.submodules.movimiento.service.almacen;

import java.util.UUID;

import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;
import com.saludsystem.submodules.movimiento.port.repository.AlmacenRepository;

public class AlmacenDeleteService
{
	private final AlmacenRepository almacenRepository;
	private final AlmacenDao almacenDao;

	public AlmacenDeleteService(AlmacenRepository almacenRepository, AlmacenDao almacenDao)
	{
		this.almacenRepository = almacenRepository;
		this.almacenDao = almacenDao;
	}

	public void execute(UUID uuid)
	{
		var almacen = almacenDao.getById(uuid);
		if (almacen.getEstado() != null && almacen.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un almacen inactivo");
		}
		almacenRepository.delete(uuid);
	}
}
