package com.saludsystem.submodules.configuracion.port.in.repository;

import java.util.UUID;

import com.saludsystem.submodules.configuracion.model.Usuario;

public interface UserRepository
{
	Usuario save(Usuario usuario);

	Usuario update(UUID uuid, Usuario usuario);

	void delete(UUID uuid);
}