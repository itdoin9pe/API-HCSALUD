package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.principal.adapter.jpa.InformacionClinicaJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.InformacionClinicaDboMapper;
import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.principal.model.constant.InformacionClinicaConstant;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class InformacionClinicaMysqlDao implements InformacionClinicaDao
{
	private final InformacionClinicaJpaRepository informacionClinicaJpaRepository;

	public InformacionClinicaMysqlDao(InformacionClinicaJpaRepository informacionClinicaJpaRepository)
	{
		this.informacionClinicaJpaRepository = informacionClinicaJpaRepository;
	}

	@Override
	public InformacionClinica getById(UUID uuid)
	{
		return informacionClinicaJpaRepository.findById(uuid).map(InformacionClinicaDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(InformacionClinicaConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<InformacionClinica> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = informacionClinicaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<InformacionClinica> data = pageResult.getContent().stream().map(InformacionClinicaDboMapper::toDomain)
				.toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<InformacionClinica> getList()
	{
		return informacionClinicaJpaRepository.findAll().stream().map(InformacionClinicaDboMapper::toDomain).toList();
	}
}
