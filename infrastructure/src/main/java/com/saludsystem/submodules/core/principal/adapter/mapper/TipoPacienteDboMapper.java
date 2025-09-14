package com.saludsystem.submodules.core.principal.adapter.mapper;

import com.saludsystem.submodules.core.principal.adapter.entity.TipoPacienteEntity;
import com.saludsystem.submodules.principal.model.TipoPaciente;

public class TipoPacienteDboMapper
{
	public static TipoPacienteEntity toEntity(TipoPaciente model)
	{
		TipoPacienteEntity entity = new TipoPacienteEntity();
		entity.setTipoPacienteId(model.getId());
		entity.setNombre(model.getNombre());

		return entity;
	}

	public static TipoPaciente toDomain(TipoPacienteEntity entity)
	{
		return new TipoPaciente(entity.getTipoPacienteId(), entity.getNombre());
	}
}
