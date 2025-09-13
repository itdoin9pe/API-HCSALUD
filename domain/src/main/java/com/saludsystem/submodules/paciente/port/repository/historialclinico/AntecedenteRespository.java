package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;

public interface AntecedenteRespository
{
	Antecedente save(Antecedente antecedente);

	Antecedente update(UUID uuid, Antecedente antecedente);

	void delete(UUID uuid);
}