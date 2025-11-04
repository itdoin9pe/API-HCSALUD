package com.saludsystem.submodules.core.configuracion.adapter.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.model.constant.TipoDocumentoConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.TipoDocumentoJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.TipoDocumentoDboMapper;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

@Component
public class TipoDocumentoMysqlDao implements TipoDocumentoDao
{
	private final TipoDocumentoJpaRepository tipoDocumentoJpaRepository;

	public TipoDocumentoMysqlDao(TipoDocumentoJpaRepository tipoDocumentoJpaRepository)
	{
		this.tipoDocumentoJpaRepository = tipoDocumentoJpaRepository;
	}

	@Override
	public TipoDocumento getById(UUID uuid)
	{
		return tipoDocumentoJpaRepository.findById(uuid).map(TipoDocumentoDboMapper::toDomain)
				.orElseThrow(() -> new ResourceNotFoundException(TipoDocumentoConstant.ID_NOT_FOUND));
	}

	@Override
	public ListResponse<TipoDocumento> getAll(UUID hospitalId, int page, int rows)
	{
		var pageable = PageRequest.of(page - 1, rows);
		var pageResult = tipoDocumentoJpaRepository.findAllByHospital_HospitalId(hospitalId, pageable);
		List<TipoDocumento> data = pageResult.getContent().stream().map(TipoDocumentoDboMapper::toDomain).toList();
		return new ListResponse<>(data, pageResult.getTotalElements(), pageResult.getTotalPages(), page);
	}

	@Override
	public List<TipoDocumento> getList()
	{
		return tipoDocumentoJpaRepository.findAll().stream().map(TipoDocumentoDboMapper::toDomain).toList();
	}
}
