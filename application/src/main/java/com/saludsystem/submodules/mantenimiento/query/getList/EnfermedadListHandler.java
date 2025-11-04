package com.saludsystem.submodules.mantenimiento.query.getList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.model.dtos.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;

@Component
public class EnfermedadListHandler
{
	private final EnfermedadDao enfermedadDao;
	private final EnfermedadMapper enfermedadMapper;

	public EnfermedadListHandler(EnfermedadDao enfermedadDao, EnfermedadMapper enfermedadMapper)
	{
		this.enfermedadDao = enfermedadDao;
		this.enfermedadMapper = enfermedadMapper;
	}

	public List<EnfermedadDTO> execute()
	{
		List<Enfermedad> enfermedadList = enfermedadDao.getList();
		return enfermedadList.stream().map(enfermedadMapper::toDto).toList();
	}
}