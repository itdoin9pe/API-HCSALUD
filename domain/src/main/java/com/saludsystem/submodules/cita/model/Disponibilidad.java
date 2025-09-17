package com.saludsystem.submodules.cita.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.saludsystem.submodules.cita.model.vo.CitaDoctorId;
import com.saludsystem.submodules.cita.model.vo.CitaSedeId;

public class Disponibilidad
{
	private CitaDoctorId doctorId;
	private CitaSedeId sedeId;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private boolean disponible;

	public boolean estaDentroDelRango(LocalDate fecha, LocalTime inicio, LocalTime fin)
	{
		return this.fecha.equals(fecha) && !inicio.isBefore(horaInicio) && !fin.isAfter(horaFin) && disponible;
	}
}