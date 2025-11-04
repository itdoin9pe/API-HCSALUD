package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Consentimiento;

public interface ConsentimientoRepository
{
	Consentimiento save(Consentimiento consentimiento);

	Consentimiento update(UUID uuid, Consentimiento consentimiento);

	void delete(UUID uuid);
}