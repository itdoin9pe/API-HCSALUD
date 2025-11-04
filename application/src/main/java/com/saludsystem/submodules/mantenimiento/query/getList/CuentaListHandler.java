package com.saludsystem.submodules.mantenimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.model.dtos.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;

@Component
public class CuentaListHandler
{
	private final CuentaDao cuentaDao;
	private final CuentaMapper cuentaMapper;

	public CuentaListHandler(CuentaDao cuentaDao, CuentaMapper cuentaMapper)
	{
		this.cuentaDao = cuentaDao;
		this.cuentaMapper = cuentaMapper;
	}

	public List<CuentaDTO> execute()
	{
		List<Cuenta> cuentaList = cuentaDao.getList();
		return cuentaList.stream().map(cuentaMapper::toDto).toList();
	}
}