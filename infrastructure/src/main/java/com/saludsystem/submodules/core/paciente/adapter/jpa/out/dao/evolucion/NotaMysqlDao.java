package com.saludsystem.submodules.core.paciente.adapter.jpa.out.dao.evolucion;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.core.paciente.adapter.jpa.interfaces.evolucion.NotaJpaRepository;
import com.saludsystem.submodules.core.paciente.adapter.mapper.evolucion.NotaDboMapper;
import com.saludsystem.submodules.paciente.model.constant.evolucion.NotaConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.Nota;
import com.saludsystem.submodules.paciente.port.dao.evolucion.NotaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class NotaMysqlDao implements NotaDao
{
	private final NotaJpaRepository notaJpaRepository;

	public NotaMysqlDao(NotaJpaRepository notaJpaRepository)
	{
		this.notaJpaRepository = notaJpaRepository;
	}

	@Override
	public Nota getById(Long id)
	{
		return notaJpaRepository.findById(id).map(NotaDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(NotaConstant.INVALID_ID));
	}

	@Override
	public ListResponse<Nota> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = notaJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<Nota> data = pageResult.getContent().stream().map(NotaDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<Nota> getList()
	{
		return notaJpaRepository.findAll().stream().map(NotaDboMapper::toDomain).toList();
	}
}
