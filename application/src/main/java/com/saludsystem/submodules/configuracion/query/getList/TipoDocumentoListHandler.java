package com.saludsystem.submodules.configuracion.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;

@Component
public class TipoDocumentoListHandler
{
	private final TipoDocumentoDao tipoDocumentoDao;
	private final TipoDocumentoMapper tipoDocumentoMapper;

	public TipoDocumentoListHandler(TipoDocumentoDao tipoDocumentoDao, TipoDocumentoMapper tipoDocumentoMapper)
	{
		this.tipoDocumentoDao = tipoDocumentoDao;
		this.tipoDocumentoMapper = tipoDocumentoMapper;
	}

	public List<TipoDocumentoDTO> execute()
	{
		List<TipoDocumento> tipoDocumentoList = tipoDocumentoDao.getList();
		return tipoDocumentoList.stream().map(tipoDocumentoMapper::toDto).toList();
	}
}