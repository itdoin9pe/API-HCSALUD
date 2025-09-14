package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.UnidadJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.UnidadDboMapper;
import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.operaciones.model.constant.UnidadConstant;
import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class UnidadMysqlDao implements UnidadDao
{
	private final UnidadJpaRepository unidadJpaRepository;

	public UnidadMysqlDao(UnidadJpaRepository unidadJpaRepository)
	{
		this.unidadJpaRepository = unidadJpaRepository;
	}

	@Override
	public Unidad getById(UUID uuid)
	{
		return unidadJpaRepository.findById(uuid).map(UnidadDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(UnidadConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Unidad> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = unidadJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Unidad> data = pageResult.getContent().stream().map(UnidadDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Unidad> getList()
	{
		return unidadJpaRepository.findAll().stream().map(UnidadDboMapper::toDomain).toList();
	}
}
