package com.saludsystem.submodules.paciente.query.getList.estadocuenta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EstadoCuentaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;

@Component
public class EstadoCuentaListHandler
{
	private final EstadoCuentaDao estadoCuentaDao;
	private final EstadoCuentaMapper estadoCuentaMapper;

	public EstadoCuentaListHandler(EstadoCuentaDao estadoCuentaDao, EstadoCuentaMapper estadoCuentaMapper)
	{
		this.estadoCuentaDao = estadoCuentaDao;
		this.estadoCuentaMapper = estadoCuentaMapper;
	}

	public List<EstadoCuentaDTO> execute()
	{
		List<EstadoCuenta> estadoCuentaList = estadoCuentaDao.getList();
		return estadoCuentaList.stream().map(estadoCuentaMapper::toDto).toList();
	}
}