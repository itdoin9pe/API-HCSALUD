package com.saludsystem.submodules.catalogo.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoCreateService;

@Component
public class MedicamentoCreateHandler
{
	private final MedicamentoCreateService medicamentoCreateService;
	private final MedicamentoMapper medicamentoMapper;

	public MedicamentoCreateHandler(
		MedicamentoCreateService medicamentoCreateService,
		MedicamentoMapper medicamentoMapper)
	{
		this.medicamentoCreateService = medicamentoCreateService;
		this.medicamentoMapper = medicamentoMapper;
	}

	public void execute(MedicamentoCreateCommand createCommand)
	{
		var medicamento = medicamentoMapper.fromCreateDto(createCommand);
		medicamentoCreateService.execute(medicamento);
	}
}