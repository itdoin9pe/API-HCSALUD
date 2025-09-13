package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.TipoPaciente;

public interface TipoPacienteRepository
{
	// some methods soon...
	TipoPaciente save(TipoPaciente tipoPaciente);

	TipoPaciente update(Long uuid, TipoPaciente tipoPaciente);

	void delete(Long id);
}