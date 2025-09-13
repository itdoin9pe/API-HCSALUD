package com.saludsystem.submodules.catalogo.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.Medicamento;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;

@Component
public class MedicamentoListHandler
{
	private final MedicamentoDao medicamentoDao;
	private final MedicamentoMapper medicamentoMapper;

	public MedicamentoListHandler(MedicamentoDao medicamentoDao, MedicamentoMapper medicamentoMapper)
	{
		this.medicamentoDao = medicamentoDao;
		this.medicamentoMapper = medicamentoMapper;
	}

	public List<MedicamentoDTO> execute()
	{
		List<Medicamento> medicamentoList = medicamentoDao.getList();
		return medicamentoList.stream().map(medicamentoMapper::toDto).toList();
	}
}