package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.interconsulta;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.interconsulta.InformeInterconsultaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.interconsulta.InformeInterconsultaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.interconsulta.InformeInterconsultaConstant;
import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InformeInterconsultaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class InformeInterconsultaMysqlDao implements InformeInterconsultaDao
{
	private final InformeInterconsultaJpaRepository informeInterconsultaJpaRepository;

	public InformeInterconsultaMysqlDao(InformeInterconsultaJpaRepository informeInterconsultaJpaRepository)
	{
		this.informeInterconsultaJpaRepository = informeInterconsultaJpaRepository;
	}

	@Override
	public List<InformeInterconsulta> getList()
	{
		return informeInterconsultaJpaRepository.findAll().stream().map(InformeInterconsultaDboMapper::toDomain)
				.toList();
	}

	@Override
	public InformeInterconsulta getById(UUID uuid)
	{
		return informeInterconsultaJpaRepository.findById(uuid).map(InformeInterconsultaDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(InformeInterconsultaConstant.INVALID_ID));
	}

	@Override
	public ListResponse<InformeInterconsulta> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = informeInterconsultaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<InformeInterconsulta> data = pageResult.getContent().stream().map(InformeInterconsultaDboMapper::toDomain)
				.toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}
}
