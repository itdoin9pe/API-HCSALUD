package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.ProveedorJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.ProveedorDboMapper;
import com.saludsystem.submodules.operaciones.model.Proveedor;
import com.saludsystem.submodules.operaciones.model.constant.ProveedorConstant;
import com.saludsystem.submodules.operaciones.port.dao.ProveedorDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class ProveedorMysqlDao implements ProveedorDao
{
	private final ProveedorJpaRepository proveedorJpaRepository;

	public ProveedorMysqlDao(ProveedorJpaRepository proveedorJpaRepository)
	{
		this.proveedorJpaRepository = proveedorJpaRepository;
	}

	@Override
	public Proveedor getById(UUID uuid)
	{
		return proveedorJpaRepository.findById(uuid).map(ProveedorDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(ProveedorConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Proveedor> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = proveedorJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Proveedor> data = pageResult.getContent().stream().map(ProveedorDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Proveedor> getList()
	{
		return List.of();
	}
}
