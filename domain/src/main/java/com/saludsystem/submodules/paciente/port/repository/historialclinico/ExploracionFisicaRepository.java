package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;

public interface ExploracionFisicaRepository
{
	ExploracionFisica save(ExploracionFisica exploracionFisica);

	ExploracionFisica update(UUID uuid, ExploracionFisica exploracionFisica);

	void delete(UUID uuid);
}