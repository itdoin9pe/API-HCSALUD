package com.saludsystem.submodules.paciente.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;

public interface PConsentimientoRepository
{
	PacienteConsentimiento save(PacienteConsentimiento pacienteConsentimiento);

	PacienteConsentimiento update(UUID uuid, PacienteConsentimiento pacienteConsentimiento);

	void delete(UUID uuid);
}