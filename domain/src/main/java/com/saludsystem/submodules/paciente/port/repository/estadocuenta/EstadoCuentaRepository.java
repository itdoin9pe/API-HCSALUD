package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EstadoCuenta;

public interface EstadoCuentaRepository
{
	EstadoCuenta save(EstadoCuenta estadoCuenta);

	EstadoCuenta update(UUID uuid, EstadoCuenta estadoCuenta);

	void delete(UUID uuid);
}