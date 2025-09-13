package com.saludsystem.submodules.paciente.service.historia.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EstadoCuentaConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EstadoCuentaRepository;

public class EstadoCuentaEditService
{
	private final EstadoCuentaDao estadoCuentaDao;
	private final EstadoCuentaRepository estadoCuentaRepository;

	public EstadoCuentaEditService(EstadoCuentaDao estadoCuentaDao, EstadoCuentaRepository estadoCuentaRepository)
	{
		this.estadoCuentaDao = estadoCuentaDao;
		this.estadoCuentaRepository = estadoCuentaRepository;
	}

	public EstadoCuenta execute(UUID uuid, EstadoCuenta estadoCuenta)
	{
		var currentEstadoCuenta = estadoCuentaDao.getById(uuid);
		if (currentEstadoCuenta == null)
		{
			throw new IllegalArgumentException(EstadoCuentaConstant.INVALID_ID);
		}
		if (currentEstadoCuenta.getEstado() != null && currentEstadoCuenta.getEstado().equals("EMPTY"))
		{
			throw new IllegalStateException("El estado de cuenta se encuentra vacio");
		}
		return estadoCuentaRepository.update(uuid, estadoCuenta);
	}
}
