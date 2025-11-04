package com.saludsystem.submodules.principal.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.principal.model.Empresa;

public interface EmpresaRepository
{
	Empresa save(Empresa empresa);

	Empresa update(UUID uuid, Empresa empresa);

	void delete(UUID uuid);
}