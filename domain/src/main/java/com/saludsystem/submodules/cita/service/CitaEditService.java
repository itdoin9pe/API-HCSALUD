package com.saludsystem.submodules.cita.service;

import java.util.UUID;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.model.constant.CitaConstant;
import com.saludsystem.submodules.cita.model.enums.EstadoCitaEnum;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

public class CitaEditService
{
	private final CitaDao citaDao;
	private final CitaRepository citaRepository;

	public CitaEditService(CitaDao citaDao, CitaRepository citaRepository)
	{
		this.citaDao = citaDao;
		this.citaRepository = citaRepository;
	}

	public Cita execute(UUID uuid, Cita cita)
	{
		var currentCita = citaDao.getById(uuid);
		if (currentCita == null)
		{
			throw new IllegalArgumentException(CitaConstant.INVALID_ID);
		}
		if (currentCita.getEstado() != null && currentCita.getEstado().value() == EstadoCitaEnum.INACTIVO)
		{
			throw new IllegalStateException("La cita ya se encuentra desactivada");
		}
		currentCita.actualizarEspecialidad(cita.getEspecialidadId());
		currentCita.actualizarDoctor(cita.getDoctorId());
		currentCita.actualizarFecha(cita.getFecha());
		currentCita.actualizarHoraInicio(cita.getHoraInicio());
		currentCita.actualizarHoraFin(cita.getHoraFin());
		currentCita.actualizarPaciente(cita.getPacienteId());
		currentCita.actualizarSede(cita.getSedeId());
		currentCita.actualizarTipoCitado(cita.getTipoCitadoId());
		currentCita.actualizarEstado(cita.getEstado());
		currentCita.actualizarMotivoConsulta(cita.getMotivoConsulta());
		currentCita.actualizarObservacion(cita.getObservacion());
		return citaRepository.update(uuid, currentCita);
	}
}