package com.saludsystem.submodules.core.operaciones.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.operaciones.adapter.jpa.PresentacionJpaReposirory;
import com.saludsystem.submodules.core.operaciones.adapter.mapper.PresentacionDboMapper;
import com.saludsystem.submodules.operaciones.model.Presentacion;
import com.saludsystem.submodules.operaciones.model.constant.PresentacionConstant;
import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class PresentacionMysqlDao implements PresentacionDao
{
	private final PresentacionJpaReposirory presentacionJpaReposirory;

	public PresentacionMysqlDao(PresentacionJpaReposirory presentacionJpaReposirory)
	{
		this.presentacionJpaReposirory = presentacionJpaReposirory;
	}

	@Override
	public Presentacion getById(UUID uuid)
	{
		return presentacionJpaReposirory.findById(uuid).map(PresentacionDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(PresentacionConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<Presentacion> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = presentacionJpaReposirory.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Presentacion> data = pageResult.getContent().stream().map(PresentacionDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Presentacion> getList()
	{
		return presentacionJpaReposirory.findAll().stream().map(PresentacionDboMapper::toDomain).toList();
	}
}
