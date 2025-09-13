package com.saludsystem.submodules.mantenimiento.query.getById;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.constant.EnfermedadConstant;
import com.saludsystem.submodules.mantenimiento.model.dtos.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;

@Component
public class EnfermedadByIdHandler
{
	private final EnfermedadDao enfermedadDao;
	private final EnfermedadMapper enfermedadMapper;

	public EnfermedadByIdHandler(EnfermedadDao enfermedadDao, EnfermedadMapper enfermedadMapper)
	{
		this.enfermedadDao = enfermedadDao;
		this.enfermedadMapper = enfermedadMapper;
	}

	public EnfermedadDTO execute(String id)
	{
		var enfermedad = enfermedadDao.getById(id);
		if (enfermedad == null)
		{
			throw new IllegalArgumentException(EnfermedadConstant.INVALID_ID);
		}
		return enfermedadMapper.toDto(enfermedad);
	}
}