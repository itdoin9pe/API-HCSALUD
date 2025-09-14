package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.movimiento.adapter.jpa.AlmacenJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.AlmacenDboMapper;
import com.saludsystem.submodules.movimiento.model.Almacen;
import com.saludsystem.submodules.movimiento.model.constant.AlmacenConstant;
import com.saludsystem.submodules.movimiento.port.dao.AlmacenDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class AlmacenMysqlDao implements AlmacenDao
{
	private final AlmacenJpaRepository almacenJpaRepository;

	public AlmacenMysqlDao(AlmacenJpaRepository almacenJpaRepository)
	{
		this.almacenJpaRepository = almacenJpaRepository;
	}

	@Override
	public Almacen getById(UUID uuid)
	{
		return almacenJpaRepository.findById(uuid).map(AlmacenDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(AlmacenConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Almacen> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = almacenJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Almacen> data = pageResult.getContent().stream().map(AlmacenDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Almacen> getList()
	{
		return almacenJpaRepository.findAll().stream().map(AlmacenDboMapper::toDomain).toList();
	}
}
