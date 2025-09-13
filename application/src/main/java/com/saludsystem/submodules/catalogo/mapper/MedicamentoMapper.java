package com.saludsystem.submodules.catalogo.mapper;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.MedicamentoEditCommand;

public class MedicamentoMapper
{
	public Medicamento fromCreateDto(MedicamentoCreateCommand dto)
	{
		return new Medicamento(null, dto.getNombre(), dto.getFormaFarmaceutica(), dto.getConcentracion(),
				dto.getContenido(), dto.getEstado());
	}

	public Medicamento fromUpdateDto(UUID uuid, MedicamentoEditCommand dto)
	{
		return new Medicamento(uuid, dto.getNombre(), dto.getFormaFarmaceutica(), dto.getConcentracion(),
				dto.getContenido(), dto.getEstado());
	}

	public MedicamentoDTO toDto(Medicamento model)
	{
		return new MedicamentoDTO(model.getId(), model.getNombre(), model.getFormaFarmaceutica(),
				model.getConcentracion(), model.getContenido(), model.getEstado());
	}
}