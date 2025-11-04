package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.historialclinico;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.ExploracionFisicaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.ExploracionFisicaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.ExploracionConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class ExploracionFisicaMysqlDao implements ExploracionFisicaDao
{
	private final ExploracionFisicaJpaRepository exploracionFisicaJpaRepository;

	public ExploracionFisicaMysqlDao(ExploracionFisicaJpaRepository exploracionFisicaJpaRepository)
	{
		this.exploracionFisicaJpaRepository = exploracionFisicaJpaRepository;
	}

	@Override
	public ExploracionFisica getById(UUID uuid)
	{
		return exploracionFisicaJpaRepository.findById(uuid).map(ExploracionFisicaDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(ExploracionConstant.INVALID_ID));
	}

	@Override
	public ListResponse<ExploracionFisica> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = exploracionFisicaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<ExploracionFisica> data = pageResult.getContent().stream().map(ExploracionFisicaDboMapper::toDomain)
				.toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<ExploracionFisica> getList()
	{
		return exploracionFisicaJpaRepository.findAll().stream().map(ExploracionFisicaDboMapper::toDomain).toList();
	}
}
