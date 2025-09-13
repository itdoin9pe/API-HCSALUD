package com.saludsystem.submodules.paciente.port.repository.estadocuenta;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;

public interface EPagoRepository
{
	EPago save(EPago ePago);

	EPago update(UUID uuid, EPago ePago);

	void delete(UUID uuid);
}