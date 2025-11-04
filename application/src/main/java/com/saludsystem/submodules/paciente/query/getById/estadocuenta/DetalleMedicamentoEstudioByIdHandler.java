package com.saludsystem.submodules.paciente.query.getById.estadocuenta;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.DetalleMedicamentoEstudioMapper;
import com.saludsystem.submodules.paciente.model.constant.estadocuenta.DetalleMedicamentoEstudioConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;

@Component
public class DetalleMedicamentoEstudioByIdHandler
{
	private final DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao;
	private final DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper;

	public DetalleMedicamentoEstudioByIdHandler(
		DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao,
		DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper)
	{
		this.detalleMedicamentoEstudioDao = detalleMedicamentoEstudioDao;
		this.detalleMedicamentoEstudioMapper = detalleMedicamentoEstudioMapper;
	}

	public DetalleMedicamentoEstudioDTO execute(UUID uuid)
	{
		var detMedicEstudio = detalleMedicamentoEstudioDao.getById(uuid);
		if (detMedicEstudio == null)
		{
			throw new IllegalArgumentException(DetalleMedicamentoEstudioConstant.INVALID_ID);
		}
		return detalleMedicamentoEstudioMapper.toDto(detMedicEstudio);
	}
}