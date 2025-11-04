package com.saludsystem.submodules.paciente.port.repository;

import java.util.UUID;

import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;

public interface MedicamentoRecetadoRepository
{
	MedicamentoRecetado save(MedicamentoRecetado medicamentoRecetado);

	MedicamentoRecetado update(UUID uuid, MedicamentoRecetado medicamentoRecetado);

	void delete(UUID uuid);
}