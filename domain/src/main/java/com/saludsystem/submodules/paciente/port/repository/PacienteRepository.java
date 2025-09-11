package com.saludsystem.submodules.paciente.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.Paciente;

public interface PacienteRepository
{
	Paciente save(Paciente paciente);
	Paciente update(UUID uuid, Paciente paciente);
	void delete(UUID uuid);
}