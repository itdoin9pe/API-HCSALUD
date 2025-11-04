package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.MedidaJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.MedidaDboMapper;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class MedidaMysqlDao implements MedidaDao
{
	private final MedidaJpaRepository medidaJpaRepository;

	public MedidaMysqlDao(MedidaJpaRepository medidaJpaRepository)
	{
		this.medidaJpaRepository = medidaJpaRepository;
	}

	@Override
	public Medida getById(UUID uuid)
	{
		return medidaJpaRepository.findById(uuid).map(MedidaDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Medida> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = medidaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Medida> data = pageResult.getContent().stream().map(MedidaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Medida> getList()
	{
		return medidaJpaRepository.findAll().stream().map(MedidaDboMapper::toDomain).toList();
	}
}