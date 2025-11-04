package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;

public interface EnfermedadRepository
{
	Enfermedad save(Enfermedad enfermedad);

	Enfermedad update(String id, Enfermedad enfermedad);

	void delete(String id);

	// List<EnfermedadDTO> getEnfermedadFiltradosPorRol();
}