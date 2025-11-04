package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.historialclinico;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.historialclinico.AntecedenteJpaRespository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico.AntecedenteDboMapper;
import com.saludsystem.submodules.paciente.model.constant.historialclinico.AntecedenteConstant;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class AntecedenteMysqlDao implements AntecedenteDao
{
	private final AntecedenteJpaRespository antecedenteJpaRespository;

	public AntecedenteMysqlDao(AntecedenteJpaRespository antecedenteJpaRespository)
	{
		this.antecedenteJpaRespository = antecedenteJpaRespository;
	}

	@Override
	public Antecedente getById(UUID uuid)
	{
		return antecedenteJpaRespository.findById(uuid).map(AntecedenteDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(AntecedenteConstant.INVALID_ID));
	}

	@Override
	public ListResponse<Antecedente> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = antecedenteJpaRespository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Antecedente> data = pageResult.getContent().stream().map(AntecedenteDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Antecedente> getList()
	{
		return antecedenteJpaRespository.findAll().stream().map(AntecedenteDboMapper::toDomain).toList();
	}
}
