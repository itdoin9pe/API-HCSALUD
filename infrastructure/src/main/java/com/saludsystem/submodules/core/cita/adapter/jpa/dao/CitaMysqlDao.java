package com.saludsystem.submodules.core.cita.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.core.cita.adapter.jpa.CitaJpaRepository;
import com.saludsystem.submodules.core.cita.adapter.mapper.CitaDboMapper;
import com.saludsystem.submodules.response.ListResponse;

/**
 * The type Cita mysql dao.
 */
@Component
public class CitaMysqlDao implements CitaDao
{
	private final CitaJpaRepository citaJpaRepository;

	public CitaMysqlDao(CitaJpaRepository citaJpaRepository)
	{
		this.citaJpaRepository = citaJpaRepository;
	}

	@Override
	public Cita getById(UUID uuid)
	{
		return citaJpaRepository.findById(uuid).map(CitaDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Cita> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = citaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Cita> data = pageResult.getContent().stream().map(CitaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Cita> getList()
	{
		return citaJpaRepository.findAll().stream().map(CitaDboMapper::toDomain).toList();
	}
}
