package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.tratamiento;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.tratamiento.ProcedimientoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.tratamiento.ProcedimientoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.ProcedimientoConstant;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class ProcedimientoMysqlDao implements ProcedimientoDao
{
	private final ProcedimientoJpaRepository procedimientoJpaRepository;

	public ProcedimientoMysqlDao(ProcedimientoJpaRepository procedimientoJpaRepository)
	{
		this.procedimientoJpaRepository = procedimientoJpaRepository;
	}

	@Override
	public Procedimiento getById(UUID uuid)
	{
		return procedimientoJpaRepository.findById(uuid).map(ProcedimientoDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(ProcedimientoConstant.INVALID_ID));
	}

	@Override
	public ListResponse<Procedimiento> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = procedimientoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Procedimiento> data = pageResult.getContent().stream().map(ProcedimientoDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Procedimiento> getList()
	{
		return procedimientoJpaRepository.findAll().stream().map(ProcedimientoDboMapper::toDomain).toList();
	}
}
