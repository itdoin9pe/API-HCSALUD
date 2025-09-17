package com.saludsystem.submodules.cita.service;

import java.util.List;

import com.saludsystem.submodules.cita.model.Cita;
import com.saludsystem.submodules.cita.model.vo.IntervaloTiempo;

public class CitaService
{
    public void validarConflicto(Cita nuevaCita, List<Cita> citasExistentes) {
        IntervaloTiempo nuevoIntervalo = new IntervaloTiempo(nuevaCita.getHoraInicio(), nuevaCita.getHoraFin());

        for (Cita cita : citasExistentes) {
            IntervaloTiempo existente = new IntervaloTiempo(cita.getHoraInicio(), cita.getHoraFin());
            if (nuevoIntervalo.seSuperpone(existente)) {
                throw new IllegalStateException("El doctor ya tiene una cita en ese horario.");
            }
        }
    }
}
