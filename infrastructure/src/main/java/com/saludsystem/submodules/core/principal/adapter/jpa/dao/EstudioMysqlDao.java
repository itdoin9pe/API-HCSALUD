package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.principal.adapter.jpa.EstudioJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.EstudioDboMapper;
import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.model.constant.EstudioConstant;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class EstudioMysqlDao implements EstudioDao
{
	private final EstudioJpaRepository estudioJpaRepository;

	public EstudioMysqlDao(EstudioJpaRepository estudioJpaRepository)
	{
		this.estudioJpaRepository = estudioJpaRepository;
	}

	@Override
	public Estudio getById(UUID uuid)
	{
		return estudioJpaRepository.findById(uuid).map(EstudioDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(EstudioConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Estudio> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = estudioJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Estudio> data = pageResult.getContent().stream().map(EstudioDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Estudio> getList()
	{
		return estudioJpaRepository.findAll().stream().map(EstudioDboMapper::toDomain).toList();
	}
}
