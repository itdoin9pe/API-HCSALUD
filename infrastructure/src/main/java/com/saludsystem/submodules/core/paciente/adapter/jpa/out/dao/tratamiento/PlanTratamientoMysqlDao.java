package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.tratamiento;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento.PlanTratamientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento.PlanTratamientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.PlanTratamientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class PlanTratamientoMysqlDao implements PlanTratamientoDao
{
	private final PlanTratamientoJpaRepository planTratamientoJpaRepository;

	public PlanTratamientoMysqlDao(PlanTratamientoJpaRepository planTratamientoJpaRepository)
	{
		this.planTratamientoJpaRepository = planTratamientoJpaRepository;
	}

	@Override
	public PlanTratamiento getById(UUID uuid)
	{
		return planTratamientoJpaRepository.findById(uuid).map(PlanTratamientoDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(PlanTratamientoConstant.INVALID_ID));
	}

	@Override
	public ListResponse<PlanTratamiento> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = planTratamientoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<PlanTratamiento> data = pageResult.getContent().stream().map(PlanTratamientoDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<PlanTratamiento> getList()
	{
		return planTratamientoJpaRepository.findAll().stream().map(PlanTratamientoDboMapper::toDomain).toList();
	}
}
