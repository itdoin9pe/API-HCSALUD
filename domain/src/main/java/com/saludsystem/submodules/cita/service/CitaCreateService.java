package com.saludsystem.submodules.cita.service;

import java.util.List;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;

public class CitaCreateService
{
	private final CitaDao citaDao;
	private final CitaRepository citaRepository;
	private final DisponibilidadService disponibilidadService;

	public CitaCreateService(
		CitaDao citaDao,
		CitaRepository citaRepository,
		com.saludsystem.submodules.cita.service.DisponibilidadService disponibilidadService)
	{
		this.citaDao = citaDao;
		this.citaRepository = citaRepository;
		this.disponibilidadService = disponibilidadService;
	}

	public Cita execute(Cita cita)
	{
		// Traer citas del mismo doctor en el mismo día
		List<Cita> existentes = citaDao.getByDoctorAndFecha(cita.getDoctorId().value(), cita.getFecha());
		disponibilidadService.validarReglasAvanzadas(cita, existentes);
		return citaRepository.save(cita);
	}
}