package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.ApoderadoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.ApoderadoDboMapper;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class ApoderadoMysqlDao implements ApoderadoDao
{
	private final ApoderadoJpaRepository apoderadoJpaRepository;

	public ApoderadoMysqlDao(ApoderadoJpaRepository apoderadoJpaRepository)
	{
		this.apoderadoJpaRepository = apoderadoJpaRepository;
	}

	@Override
	public Apoderado getById(UUID uuid)
	{
		return apoderadoJpaRepository.findById(uuid).map(ApoderadoDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Apoderado> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = apoderadoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Apoderado> data = pageResult.getContent().stream().map(ApoderadoDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Apoderado> getList()
	{
		return apoderadoJpaRepository.findAll().stream().map(ApoderadoDboMapper::toDomain).toList();
	}
}