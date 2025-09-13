package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.model.Empresa;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;

public class EmpresaCreateService
{
	private final EmpresaRepository empresaRepository;

	public EmpresaCreateService(EmpresaRepository empresaRepository)
	{
		this.empresaRepository = empresaRepository;
	}

	public Empresa execute(Empresa empresa)
	{
		return empresaRepository.save(empresa);
	}
}
