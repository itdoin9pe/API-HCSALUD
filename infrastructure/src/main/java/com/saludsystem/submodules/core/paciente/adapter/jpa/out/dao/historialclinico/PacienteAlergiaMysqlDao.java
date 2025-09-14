package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.historialclinico;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.PacienteAlergiaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.PacienteAlergiaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.PacienteAlergiaConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class PacienteAlergiaMysqlDao implements PacienteAlergiaDao
{
	private final PacienteAlergiaJpaRepository pacienteAlergiaJpaRepository;

	public PacienteAlergiaMysqlDao(PacienteAlergiaJpaRepository pacienteAlergiaJpaRepository)
	{
		this.pacienteAlergiaJpaRepository = pacienteAlergiaJpaRepository;
	}

	@Override
	public PacienteAlergia getById(UUID uuid)
	{
		return pacienteAlergiaJpaRepository.findById(uuid).map(PacienteAlergiaDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(PacienteAlergiaConstant.INVALID_ID));
	}

	@Override
	public ListResponse<PacienteAlergia> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = pacienteAlergiaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<PacienteAlergia> data = pageResult.getContent().stream().map(PacienteAlergiaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<PacienteAlergia> getList()
	{
		return pacienteAlergiaJpaRepository.findAll().stream().map(PacienteAlergiaDboMapper::toDomain).toList();
	}
}
