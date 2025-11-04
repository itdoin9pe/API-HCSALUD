package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.EnfermedadJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.EnfermedadDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class EnfermedadMysqlDao implements EnfermedadDao
{
	private final EnfermedadJpaRepository enfermedadJpaRepository;

	public EnfermedadMysqlDao(EnfermedadJpaRepository enfermedadJpaRepository)
	{
		this.enfermedadJpaRepository = enfermedadJpaRepository;
	}

	@Override
	public Enfermedad getById(String uuid)
	{
		return enfermedadJpaRepository.findById(uuid).map(EnfermedadDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Enfermedad> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = enfermedadJpaRepository.findByHospital_HospitalId(hospitalId, pageable);
		List<Enfermedad> data = pageResult.getContent().stream().map(EnfermedadDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Enfermedad> getList()
	{
		return enfermedadJpaRepository.findAll().stream().map(EnfermedadDboMapper::toDomain).toList();
	}
}
