package com.saludsystem.submodules.mantenimiento.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.mantenimiento.model.Banco;

public interface BancoRepository
{
	Banco save(Banco banco);

	Banco update(UUID uuid, Banco banco);

	void delete(UUID uuid);
}