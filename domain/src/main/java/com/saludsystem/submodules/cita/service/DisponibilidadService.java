package com.saludsystem.submodules.cita.service;

import java.util.List;

import com.saludsystem.submodules.cita.model.Cita;

public class DisponibilidadService
{
    /**
     * Verifica si la cita se cruza con alguna existente.
     */
	public boolean hayChoque(Cita nuevaCita, List<Cita> existentes)
	{
		return existentes.stream()
				.anyMatch(cita -> cita.getDoctorId().equals(nuevaCita.getDoctorId())
						&& cita.getFecha().equals(nuevaCita.getFecha())
						&& ((nuevaCita.getHoraInicio().isBefore(cita.getHoraFin())
								&& nuevaCita.getHoraFin().isAfter(cita.getHoraInicio()))));
	}
	
    /**
     * Valida otras reglas de negocio (ejemplo: no más de 8 citas al día por doctor).
     */
    public void validarReglasAvanzadas(Cita nueva, List<Cita> existentes) {
        long totalEseDia = existentes.stream()
                .filter(c -> c.getDoctorId().equals(nueva.getDoctorId()))
                .count();

        if (totalEseDia >= 8) {
            throw new IllegalStateException("El doctor ya alcanzó el máximo de citas por día");
        }

        if (hayChoque(nueva, existentes)) {
            throw new IllegalStateException("El doctor ya tiene una cita en ese horario");
        }
    }
}
