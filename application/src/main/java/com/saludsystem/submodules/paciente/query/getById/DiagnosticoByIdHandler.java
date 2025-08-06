package com.saludsystem.submodules.paciente.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.DiagnosticoMapper;
import com.saludsystem.submodules.paciente.model.constant.DiagnosticoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.DiagnosticoDTO;
import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;

@Component
public class DiagnosticoByIdHandler {

	private final DiagnosticoDao diagnosticoDao;
	private final DiagnosticoMapper diagnosticoMapper;

	/**
	 * @param diagnosticoDao
	 * @param diagnosticoMapper
	 */
	public DiagnosticoByIdHandler(DiagnosticoDao diagnosticoDao, DiagnosticoMapper diagnosticoMapper) {
		this.diagnosticoDao = diagnosticoDao;
		this.diagnosticoMapper = diagnosticoMapper;
	}

	public DiagnosticoDTO execute(UUID uuid) {
		
		var diagnostico = diagnosticoDao.getById(uuid);
		
		if (diagnostico == null) {
			throw new IllegalArgumentException(DiagnosticoConstant.INVALID_ID);
		}
		
		return diagnosticoMapper.toDto(diagnostico);
		
	}
	
}
