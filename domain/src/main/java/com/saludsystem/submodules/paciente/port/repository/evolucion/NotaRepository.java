package com.saludsystem.submodules.paciente.port.repository.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;

public interface NotaRepository
{
	Nota save(Nota nota);

	Nota update(Long id, Nota nota);

	void delete(Long id);
}