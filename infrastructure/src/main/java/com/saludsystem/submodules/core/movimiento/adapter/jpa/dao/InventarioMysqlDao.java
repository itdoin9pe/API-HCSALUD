package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.movimiento.adapter.jpa.InventarioJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.InventarioDboMapper;
import com.saludsystem.submodules.movimiento.model.Inventario;
import com.saludsystem.submodules.movimiento.model.constant.InventarioConstant;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class InventarioMysqlDao implements InventarioDao
{
	private final InventarioJpaRepository inventarioJpaRepository;

	public InventarioMysqlDao(InventarioJpaRepository inventarioJpaRepository)
	{
		this.inventarioJpaRepository = inventarioJpaRepository;
	}

	@Override
	public Inventario getById(UUID uuid)
	{
		return inventarioJpaRepository.findById(uuid).map(InventarioDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(InventarioConstant.INVALID_ID));
	}

	@Override
	public ListResponse<Inventario> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = inventarioJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Inventario> data = pageResult.getContent().stream().map(InventarioDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Inventario> getList()
	{
		return inventarioJpaRepository.findAll().stream().map(InventarioDboMapper::toDomain).toList();
	}
}
