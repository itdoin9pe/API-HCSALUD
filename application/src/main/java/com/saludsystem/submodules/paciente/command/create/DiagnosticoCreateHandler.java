package com.saludsystem.submodules.paciente.command.create;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.DiagnosticoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.DiagnosticoCreateCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico.DiagnosticoCreateService;

@Component
public class DiagnosticoCreateHandler {

	private final DiagnosticoCreateService diagnosticoCreateService;
	private final DiagnosticoMapper diagnosticoMapper;
	/**
	 * @param diagnosticoCreateService
	 * @param diagnosticoMapper
	 */
	public DiagnosticoCreateHandler(DiagnosticoCreateService diagnosticoCreateService,
			DiagnosticoMapper diagnosticoMapper) {
		this.diagnosticoCreateService = diagnosticoCreateService;
		this.diagnosticoMapper = diagnosticoMapper;
	}
	
	public void execute(DiagnosticoCreateCommand createCommand) {
		
		var diagnosticoSaved = diagnosticoMapper.fromCreateDto(createCommand);
		
		diagnosticoCreateService.execute(diagnosticoSaved);
		
	}

}
