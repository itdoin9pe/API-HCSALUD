package com.saludsystem.submodules.core.catalogo.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.core.catalogo.adapter.jpa.MedicamentoJpaRepository;
import com.saludsystem.submodules.core.catalogo.adapter.mapper.MedicamentoDboMapper;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class MedicamentoMysqlDao implements MedicamentoDao
{
	private final MedicamentoJpaRepository medicamentoJpaRepository;

	public MedicamentoMysqlDao(MedicamentoJpaRepository medicamentoJpaRepository)
	{
		this.medicamentoJpaRepository = medicamentoJpaRepository;
	}

	@Override
	public Medicamento getById(UUID uuid)
	{
		return medicamentoJpaRepository.findById(uuid).map(MedicamentoDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Medicamento> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = medicamentoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Medicamento> data = pageResult.getContent().stream().map(MedicamentoDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Medicamento> getList()
	{
		return medicamentoJpaRepository.findAll().stream().map(MedicamentoDboMapper::toDomain).toList();
	}
}