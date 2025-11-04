package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.AlergiaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.AlergiaDboMapper;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class AlergiaMysqlDao implements AlergiaDao
{

	private final AlergiaJpaRepository alergiaJpaRepository;

	public AlergiaMysqlDao(AlergiaJpaRepository alergiaJpaRepository)
	{
		this.alergiaJpaRepository = alergiaJpaRepository;
	}

	@Override
	public Alergia getById(UUID id)
	{
		return alergiaJpaRepository.findById(id).map(AlergiaDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Alergia> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = alergiaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Alergia> data = pageResult.getContent().stream().map(AlergiaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Alergia> getList()
	{
		return alergiaJpaRepository.findAll().stream().map(AlergiaDboMapper::toDomain).toList();
	}
}