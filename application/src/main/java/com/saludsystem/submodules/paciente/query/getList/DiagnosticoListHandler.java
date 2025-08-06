package com.saludsystem.submodules.paciente.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.DiagnosticoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.DiagnosticoDTO;
import com.saludsystem.submodules.paciente.model.entity.Diagnostico;
import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;

@Component
public class DiagnosticoListHandler {

	private final DiagnosticoDao diagnosticoDao;
	private final DiagnosticoMapper diagnosticoMapper;
	/**
	 * @param diagnosticoDao
	 * @param diagnosticoMapper
	 */
	public DiagnosticoListHandler(DiagnosticoDao diagnosticoDao, DiagnosticoMapper diagnosticoMapper) {
		this.diagnosticoDao = diagnosticoDao;
		this.diagnosticoMapper = diagnosticoMapper;
	}

	public List<DiagnosticoDTO> execute() {
		
		List<Diagnostico> diagList = diagnosticoDao.getList();
		
		return diagList.stream()
				.map(diagnosticoMapper::toDto)
				.toList();
		
	}
	
}
