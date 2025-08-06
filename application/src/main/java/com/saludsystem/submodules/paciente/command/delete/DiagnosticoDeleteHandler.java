package com.saludsystem.submodules.paciente.command.delete;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico.DiagnosticoDeleteService;

@Component
public class DiagnosticoDeleteHandler {

	private final DiagnosticoDeleteService diagnosticoDeleteService;

	/**
	 * @param diagnosticoDeleteService
	 */
	public DiagnosticoDeleteHandler(DiagnosticoDeleteService diagnosticoDeleteService) {
		this.diagnosticoDeleteService = diagnosticoDeleteService;
	}
	
	public void execute(UUID uuid) {
		
		diagnosticoDeleteService.execute(uuid);
		
	}

}
