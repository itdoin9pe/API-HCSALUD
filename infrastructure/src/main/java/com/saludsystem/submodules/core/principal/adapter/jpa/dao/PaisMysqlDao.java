package com.saludsystem.submodules.core.principal.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.principal.adapter.jpa.PaisJpaRepository;
import com.saludsystem.submodules.core.principal.adapter.mapper.PaisDboMapper;
import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.model.constant.PaisConstant;
import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class PaisMysqlDao implements PaisDao
{
	private final PaisJpaRepository paisJpaRepository;

	public PaisMysqlDao(PaisJpaRepository paisJpaRepository)
	{
		this.paisJpaRepository = paisJpaRepository;
	}

	@Override
	public Pais getById(Integer id)
	{
		return paisJpaRepository.findById(id).map(PaisDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(PaisConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Pais> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = paisJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Pais> data = pageResult.getContent().stream().map(PaisDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Pais> getList()
	{
		return paisJpaRepository.findAll().stream().map(PaisDboMapper::toDomain).toList();
	}
}
