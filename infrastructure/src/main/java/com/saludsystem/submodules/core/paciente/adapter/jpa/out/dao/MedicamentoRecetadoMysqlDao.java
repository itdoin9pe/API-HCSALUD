package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.MedicamentoRecetadoJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.MedicamentoRecetadoDboMapper;
import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class MedicamentoRecetadoMysqlDao implements MedicamentoRecetadoDao
{
	private final MedicamentoRecetadoJpaRepository medicamentoRecetadoJpaRepository;

	public MedicamentoRecetadoMysqlDao(MedicamentoRecetadoJpaRepository medicamentoRecetadoJpaRepository)
	{
		this.medicamentoRecetadoJpaRepository = medicamentoRecetadoJpaRepository;
	}

	@Override
	public MedicamentoRecetado getById(UUID uuid)
	{
		return medicamentoRecetadoJpaRepository.findById(uuid).map(MedicamentoRecetadoDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(MedicamentoRecetadoConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<MedicamentoRecetado> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = medicamentoRecetadoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<MedicamentoRecetado> data = pageResult.getContent().stream().map(MedicamentoRecetadoDboMapper::toDomain)
				.toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<MedicamentoRecetado> getList()
	{
		return medicamentoRecetadoJpaRepository.findAll().stream().map(MedicamentoRecetadoDboMapper::toDomain).toList();
	}
}
