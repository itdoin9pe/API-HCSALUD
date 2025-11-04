package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Cliente;

public interface ClienteRepository
{
	Cliente save(Cliente cliente);

	Cliente update(UUID uuid, Cliente cliente);

	void delete(UUID uuid);
}