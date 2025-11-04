package com.saludsystem.submodules.principal.service.empresa;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.model.constant.EmpresaConstant;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;

public class EmpresaEditService
{
	private final EmpresaDao empresaDao;
	private final EmpresaRepository empresaRepository;

	public EmpresaEditService(EmpresaDao empresaDao, EmpresaRepository empresaRepository)
	{
		this.empresaDao = empresaDao;
		this.empresaRepository = empresaRepository;
	}

	public Empresa execute(UUID uuid, Empresa empresa)
	{
		var currentEmpresa = empresaDao.getById(uuid);
		if (currentEmpresa == null)
		{
			throw new IllegalArgumentException(EmpresaConstant.ID_NOT_FOUND);
		}
		if (currentEmpresa.getEstado() != null && currentEmpresa.getEstado() == 0)
		{
			throw new IllegalStateException("La emoresa ya se encuentra desactivada");
		}
		return empresaRepository.update(uuid, empresa);
	}
}
