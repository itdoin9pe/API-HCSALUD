package com.saludsystem.submodules.catalogo.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medicamento;

public interface MedicamentoRepository
{
	Medicamento save(Medicamento medicamento);

	Medicamento update(UUID uuid, Medicamento medicamento);

	void delete(UUID uuid);
}