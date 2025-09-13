package com.saludsystem.submodules.paciente.query.getList.estadocuenta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.DetalleMedicamentoEstudioMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.DetalleMedicamentoEstudio;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;

@Component
public class DetalleMedicamentoEstudioListHandler
{
	private final DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao;
	private final DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper;

	public DetalleMedicamentoEstudioListHandler(
		DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao,
		DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper)
	{
		this.detalleMedicamentoEstudioDao = detalleMedicamentoEstudioDao;
		this.detalleMedicamentoEstudioMapper = detalleMedicamentoEstudioMapper;
	}

	public List<DetalleMedicamentoEstudioDTO> execute()
	{
		List<DetalleMedicamentoEstudio> detalleMedicamentoEstudioList = detalleMedicamentoEstudioDao.getList();
		return detalleMedicamentoEstudioList.stream().map(detalleMedicamentoEstudioMapper::toDto).toList();
	}
}