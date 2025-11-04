package com.saludsystem.submodules.principal.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.model.constant.EmpresaConstant;
import com.saludsystem.submodules.principal.model.dtos.EmpresaDTO;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;

@Component
public class EmpresaByIdHandler
{
	private final EmpresaDao empresaDao;
	private final EmpresaMapper empresaMapper;

	public EmpresaByIdHandler(EmpresaDao empresaDao, EmpresaMapper empresaMapper)
	{
		this.empresaDao = empresaDao;
		this.empresaMapper = empresaMapper;
	}

	public EmpresaDTO execute(UUID uuid)
	{
		var empresa = empresaDao.getById(uuid);
		if (empresa == null)
		{
			throw new IllegalArgumentException(EmpresaConstant.INVALID_ID);
		}
		return empresaMapper.toDto(empresa);
	}
}