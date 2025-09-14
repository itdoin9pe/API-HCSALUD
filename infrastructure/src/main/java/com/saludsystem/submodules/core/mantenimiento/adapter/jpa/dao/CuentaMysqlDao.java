package com.saludsystem.submodules.core.mantenimiento.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.mantenimiento.adapter.jpa.CuentaJpaRepository;
import com.saludsystem.submodules.core.mantenimiento.adapter.mapper.CuentaDboMapper;
import com.saludsystem.submodules.mantenimiento.model.Cuenta;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.response.ListResponse;

@Component
public class CuentaMysqlDao implements CuentaDao
{
	private final CuentaJpaRepository cuentaJpaRepository;

	public CuentaMysqlDao(CuentaJpaRepository cuentaJpaRepository)
	{
		this.cuentaJpaRepository = cuentaJpaRepository;
	}

	@Override
	public Cuenta getById(UUID uuid)
	{
		return cuentaJpaRepository.findById(uuid).map(CuentaDboMapper::toDomain).orElse(null);
	}

	@Override
	public ListResponse<Cuenta> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = cuentaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Cuenta> data = pageResult.getContent().stream().map(CuentaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Cuenta> getList()
	{
		return cuentaJpaRepository.findAll().stream().map(CuentaDboMapper::toDomain).toList();
	}
}
