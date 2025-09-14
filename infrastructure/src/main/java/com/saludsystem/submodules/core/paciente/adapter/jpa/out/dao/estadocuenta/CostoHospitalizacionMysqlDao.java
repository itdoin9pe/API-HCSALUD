package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.estadocuenta;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.estadocuenta.CostoHospitalizacionJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.estadocuenta.CostoHospitalizacionDboMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.CostoHospitalizacionConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.CostoHospitalizacion;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class CostoHospitalizacionMysqlDao implements CostoHospitalizacionDao
{
	private final CostoHospitalizacionJpaRepository costoHospitalizacionJpaRepository;

	public CostoHospitalizacionMysqlDao(CostoHospitalizacionJpaRepository costoHospitalizacionJpaRepository)
	{
		this.costoHospitalizacionJpaRepository = costoHospitalizacionJpaRepository;
	}

	@Override
	public CostoHospitalizacion getById(UUID uuid)
	{
		return costoHospitalizacionJpaRepository.findById(uuid).map(CostoHospitalizacionDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(CostoHospitalizacionConstant.INVALID_ID));
	}

	@Override
	public ListResponse<CostoHospitalizacion> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = costoHospitalizacionJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<CostoHospitalizacion> data = pageResult.getContent().stream().map(CostoHospitalizacionDboMapper::toDomain)
				.toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<CostoHospitalizacion> getList()
	{
		return costoHospitalizacionJpaRepository.findAll().stream().map(CostoHospitalizacionDboMapper::toDomain)
				.toList();
	}
}
