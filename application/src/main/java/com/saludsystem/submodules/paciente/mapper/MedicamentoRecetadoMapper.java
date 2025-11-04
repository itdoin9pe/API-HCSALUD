package com.saludsystem.submodules.paciente.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.saludsystem.submodules.paciente.model.dtos.command.create.MedicamentoRecetadoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.MedicamentoRecetadoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;

public class MedicamentoRecetadoMapper
{
	public MedicamentoRecetado fromCreateDto(MedicamentoRecetadoCreateCommand createCommand)
	{
		return new MedicamentoRecetado(null, createCommand.getPacienteRecetaId(), createCommand.getMedicamentoId(),
				createCommand.getDosis(), createCommand.getFrecuencia(), createCommand.getDuracionDias(),
				createCommand.getIndicaciones());
	}

	public MedicamentoRecetado fromUpdateDto(UUID uuid, MedicamentoRecetadoEditCommand editCommand)
	{
		return new MedicamentoRecetado(null, editCommand.getPacienteRecetaId(), editCommand.getMedicamentoId(),
				editCommand.getDosis(), editCommand.getFrecuencia(), editCommand.getDuracionDias(),
				editCommand.getIndicaciones());
	}

	public MedicamentoRecetado fromDto(MedicamentoRecetadoDTO dto)
	{
		return new MedicamentoRecetado(dto.getMedicamentoRecetadoId(), dto.getPacienteRecetaId(),
				dto.getMedicamentoId(), dto.getDosis(), dto.getFrecuencia(), dto.getDuracionDias(),
				dto.getIndicaciones());
	}

	public MedicamentoRecetadoDTO toDto(MedicamentoRecetado model)
	{
		return new MedicamentoRecetadoDTO(model.getId(), model.getPacienteRecetaId(), model.getMedicamentoId(),
				model.getDosis(), model.getFrecuencia(), model.getDuracionDias(), model.getIndicaciones());
	}

	public List<MedicamentoRecetado> fromDtoList(List<MedicamentoRecetadoDTO> dtos)
	{
		return dtos == null ? null : dtos.stream().map(this::fromDto).collect(Collectors.toList());
	}

	public List<MedicamentoRecetadoDTO> toDtoList(List<MedicamentoRecetado> entities)
	{
		return entities == null ? null : entities.stream().map(this::toDto).collect(Collectors.toList());
	}
}