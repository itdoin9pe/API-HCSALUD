package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Categoria;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.CategoriaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.CategoriaDboMapper;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class CategoriaMysqlDao implements CategoriaDao
{
	private final CategoriaJpaRepository categoriaJpaRepository;

	public CategoriaMysqlDao(CategoriaJpaRepository categoriaJpaRepository)
	{
		this.categoriaJpaRepository = categoriaJpaRepository;
	}

	@Override
	public Categoria getById(UUID uuid)
	{
		return categoriaJpaRepository.findById(uuid).map(CategoriaDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Categoria> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = categoriaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Categoria> data = pageResult.getContent().stream().map(CategoriaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Categoria> getList()
	{
		return categoriaJpaRepository.findAll().stream().map(CategoriaDboMapper::toDomain).toList();
	}
}
