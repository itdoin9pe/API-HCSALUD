package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.DiagnosticoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.DiagnosticoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.DiagnosticoConstant;
import com.saludsystem.submodules.paciente.model.entity.Diagnostico;
import com.saludsystem.submodules.paciente.port.dao.DiagnosticoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class DiagnosticoMysqlDao implements DiagnosticoDao {
	
	private final DiagnosticoJpaRepository diagnosticoJpaRepository;
	

	public DiagnosticoMysqlDao(DiagnosticoJpaRepository diagnosticoJpaRepository) {
		this.diagnosticoJpaRepository = diagnosticoJpaRepository;
	}

	@Override
	public Diagnostico getById(UUID uuid) {
		// TODO Auto-generated method stub
		return diagnosticoJpaRepository.findById(uuid)
				.map(DiagnosticoDboMapper::toDomain)
				.orElseThrow( () -> new ResourceNotFoundException(DiagnosticoConstant.ID_NOT_FOUND) );
	}

	@Override
	public ListResponse<Diagnostico> getAll(UUID hospitalId, int page, int rows) {
		// TODO Auto-generated method stub
	      var pageable = PageRequest.of(page - 1, rows);
	        var pageResult = diagnosticoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
	        List<Diagnostico> data = pageResult.getContent()
	                .stream()
	                .map(DiagnosticoDboMapper::toDomain)
	                .toList();
	        return new ListResponse<>(data, pageResult.getTotalElements(),
	                pageResult.getTotalPages(), page);
	}

	@Override
	public List<Diagnostico> getList() {
		// TODO Auto-generated method stub
		return diagnosticoJpaRepository.findAll()
				.stream()
				.map(DiagnosticoDboMapper::toDomain)
				.toList();
	}
}
