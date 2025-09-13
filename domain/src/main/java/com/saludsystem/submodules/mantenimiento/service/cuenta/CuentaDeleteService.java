package com.saludsystem.submodules.mantenimiento.service.cuenta;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CuentaRepository;

public class CuentaDeleteService
{
	private final CuentaRepository cuentaRepository;
	private final CuentaDao cuentaDao;

	public CuentaDeleteService(CuentaRepository cuentaRepository, CuentaDao cuentaDao)
	{
		this.cuentaRepository = cuentaRepository;
		this.cuentaDao = cuentaDao;
	}

	public void execute(UUID uuid)
	{
		var cuenta = cuentaDao.getById(uuid);
		if (cuenta.getEstado() != null && cuenta.getEstado() == 0)
		{
			throw new IllegalStateException("No se puede eliminar un tipo de cuenta ya desactivada");
		}
		cuentaRepository.delete(uuid);
	}
}
