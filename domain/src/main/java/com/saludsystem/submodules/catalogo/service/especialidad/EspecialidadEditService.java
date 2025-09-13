package com.saludsystem.submodules.catalogo.service.especialidad;

import java.util.UUID;

import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.model.constant.EspecialidadConstant;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;

public class EspecialidadEditService
{
	private final EspecialidadDao especialidadDao;
	private final EspecialidadRepository especialidadRepository;

	public EspecialidadEditService(EspecialidadDao especialidadDao, EspecialidadRepository especialidadRepository)
	{
		this.especialidadDao = especialidadDao;
		this.especialidadRepository = especialidadRepository;
	}

	public Especialidad execute(UUID uuid, Especialidad especialidad)
	{
		var currentEspecialidad = especialidadDao.getById(uuid);
		if (currentEspecialidad == null)
		{
			throw new IllegalArgumentException(EspecialidadConstant.INVALID_ID);
		}
		if (currentEspecialidad.getEstado() != null && currentEspecialidad.getEstado() == 0)
		{
			throw new IllegalStateException("La especialidad ya se encuentra desactivada");
		}
		currentEspecialidad.actualizarNombre(especialidad.getNombre());
		currentEspecialidad.actualizarDescripcion(especialidad.getDescripcion());
		currentEspecialidad.actualizarEstado(especialidad.getEstado());
		return especialidadRepository.update(uuid, currentEspecialidad);
	}
}