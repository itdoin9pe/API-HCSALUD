package com.saludsystem.submodules.cita.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.cita.model.Cita;

public interface CitaRepository
{
	Cita save(Cita cita);

	Cita update(UUID uuid, Cita cita);

	void delete(UUID uuid);
}