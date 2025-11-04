package com.saludsystem.submodules.paciente.query.getById;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.paciente.mapper.MedicamentoRecetadoMapper;
import com.saludsystem.submodules.paciente.model.constant.MedicamentoRecetadoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;

@Component
public class MedicamentoRecetadoByIdHandler
{
	private final MedicamentoRecetadoDao medicamentoRecetadoDao;
	private final MedicamentoRecetadoMapper medicamentoRecetadoMapper;

	public MedicamentoRecetadoByIdHandler(
		MedicamentoRecetadoDao medicamentoRecetadoDao,
		MedicamentoRecetadoMapper medicamentoRecetadoMapper)
	{
		this.medicamentoRecetadoDao = medicamentoRecetadoDao;
		this.medicamentoRecetadoMapper = medicamentoRecetadoMapper;
	}

	public MedicamentoRecetadoDTO execute(UUID uuid)
	{
		var medicamentoRecetado = medicamentoRecetadoDao.getById(uuid);
		if (medicamentoRecetado == null)
		{
			throw new IllegalArgumentException(MedicamentoRecetadoConstant.INVALID_ID);
		}
		return medicamentoRecetadoMapper.toDto(medicamentoRecetado);
	}
}