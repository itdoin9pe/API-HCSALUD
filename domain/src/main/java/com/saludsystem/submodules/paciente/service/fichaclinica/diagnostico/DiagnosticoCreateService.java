package com.saludsystem.submodules.paciente.service.fichaclinica.diagnostico;

import com.saludsystem.submodules.paciente.model.entity.Diagnostico;
import com.saludsystem.submodules.paciente.port.repository.DiagnosticoRepository;

public class DiagnosticoCreateService {

	private final DiagnosticoRepository diagnosticoRepository;

	/**
	 * @param diagnosticoRepository
	 */
	public DiagnosticoCreateService(DiagnosticoRepository diagnosticoRepository) {
		this.diagnosticoRepository = diagnosticoRepository;
	}

	public Diagnostico execute(Diagnostico diagnostico) {
		
		return diagnosticoRepository.save(diagnostico);
		
	}
	
}
