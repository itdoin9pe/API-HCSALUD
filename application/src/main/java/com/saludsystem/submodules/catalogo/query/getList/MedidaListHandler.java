package com.saludsystem.submodules.catalogo.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.Medida;
import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;

@Component
public class MedidaListHandler
{
	private final MedidaDao medidaDao;
	private final MedidaMapper medidaMapper;

	public MedidaListHandler(MedidaDao medidaDao, MedidaMapper medidaMapper)
	{
		this.medidaDao = medidaDao;
		this.medidaMapper = medidaMapper;
	}

	public List<MedidaDTO> execute()
	{
		List<Medida> medidaList = medidaDao.getList();
		return medidaList.stream().map(medidaMapper::toDto).toList();
	}
}