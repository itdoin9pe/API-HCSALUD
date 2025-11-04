package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.port.repository.CuentaRepository;

public class CuentaCreateService
{
	private final CuentaRepository cuentaRepository;

	public CuentaCreateService(CuentaRepository cuentaRepository)
	{
		this.cuentaRepository = cuentaRepository;
	}

	public Cuenta execute(Cuenta cuenta)
	{

		return cuentaRepository.save(cuenta);

	}
}
