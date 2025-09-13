package com.saludsystem.submodules.paciente.query.getById.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EstadoCuentaMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EstadoCuentaConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;

@Component
public class EstadoCuentaByIdHandler
{
	private final EstadoCuentaDao estadoCuentaDao;
	private final EstadoCuentaMapper estadoCuentaMapper;

	public EstadoCuentaByIdHandler(EstadoCuentaDao estadoCuentaDao, EstadoCuentaMapper estadoCuentaMapper)
	{
		this.estadoCuentaDao = estadoCuentaDao;
		this.estadoCuentaMapper = estadoCuentaMapper;
	}

	public EstadoCuentaDTO execute(UUID uuid)
	{
		var estadoCuenta = estadoCuentaDao.getById(uuid);
		if (estadoCuenta == null)
		{
			throw new IllegalStateException(EstadoCuentaConstant.INVALID_ID);
		}
		return estadoCuentaMapper.toDto(estadoCuenta);
	}
}