package com.saludsystem.submodules.cita.port.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.response.ListResponse;

public interface CitaDao
{
	Cita getById(UUID uuid);

	ListResponse<Cita> getAll(UUID hospitalId, int page, int rows);

	List<Cita> getList();

	List<Cita> getByDoctorAndFecha(UUID doctorId, LocalDate fecha);
}