package com.saludsystem.submodules.core.movimiento.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.movimiento.adapter.jpa.CompraDetalleJpaRepository;
import com.saludsystem.submodules.core.movimiento.adapter.mapper.CompraDetalleDboMapper;
import com.saludsystem.submodules.movimiento.model.CompraDetalle;
import com.saludsystem.submodules.movimiento.model.constant.CompraDetalleConstant;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class CompraDetalleMysqlDao implements CompraDetalleDao
{
	private final CompraDetalleJpaRepository compraDetalleJpaRepository;

	public CompraDetalleMysqlDao(CompraDetalleJpaRepository compraDetalleJpaRepository)
	{
		this.compraDetalleJpaRepository = compraDetalleJpaRepository;
	}

	@Override
	public CompraDetalle getById(UUID uuid)
	{
		return compraDetalleJpaRepository.findById(uuid).map(CompraDetalleDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(CompraDetalleConstant.INVALID_ID));
	}

	@Override
	public ListResponse<CompraDetalle> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = compraDetalleJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<CompraDetalle> data = pageResult.getContent().stream().map(CompraDetalleDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<CompraDetalle> getList()
	{
		return compraDetalleJpaRepository.findAll().stream().map(CompraDetalleDboMapper::toDomain).toList();
	}
}
