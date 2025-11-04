package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.ProductoJpaRepository;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.ProductoDboMapper;
import com.saludsystem.submodules.operaciones.model.Producto;
import com.saludsystem.submodules.operaciones.model.constant.ProductoConstant;
import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class ProductoMysqlDao implements ProductoDao
{
	private final ProductoJpaRepository productoJpaRepository;

	public ProductoMysqlDao(ProductoJpaRepository productoJpaRepository)
	{
		this.productoJpaRepository = productoJpaRepository;
	}

	@Override
	public Producto getById(UUID uuid)
	{
		return productoJpaRepository.findById(uuid).map(ProductoDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(ProductoConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Producto> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = productoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Producto> data = pageResult.getContent().stream().map(ProductoDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Producto> getList()
	{
		return productoJpaRepository.findAll().stream().map(ProductoDboMapper::toDomain).toList();
	}
}
