package com.saludsystem.submodules.paciente.port.repository.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;

public interface CambioCondicionRepository
{
	CambioCondicion save(CambioCondicion cambioCondicion);

	CambioCondicion update(Long id, CambioCondicion cambioCondicion);

	void delete(Long id);
}