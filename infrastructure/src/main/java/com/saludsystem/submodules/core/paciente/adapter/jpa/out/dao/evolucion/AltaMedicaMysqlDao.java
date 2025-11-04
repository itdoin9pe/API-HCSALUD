package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.evolucion;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.AltaMedicaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.AltaMedicaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.AltaMedicaConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;
import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class AltaMedicaMysqlDao implements AltaMedicaDao
{
	private final AltaMedicaJpaRepository altaMedicaJpaRepository;

	public AltaMedicaMysqlDao(AltaMedicaJpaRepository altaMedicaJpaRepository)
	{
		this.altaMedicaJpaRepository = altaMedicaJpaRepository;
	}

	@Override
	public AltaMedica getById(Long id)
	{
		return altaMedicaJpaRepository.findById(id).map(AltaMedicaDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(AltaMedicaConstant.INVALID_ID));
	}

	@Override
	public ListResponse<AltaMedica> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = altaMedicaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<AltaMedica> data = pageResult.getContent().stream().map(AltaMedicaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<AltaMedica> getList()
	{
		return altaMedicaJpaRepository.findAll().stream().map(AltaMedicaDboMapper::toDomain).toList();
	}
}
