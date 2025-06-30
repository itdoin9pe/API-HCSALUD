package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarExploracionFisicaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        ExploracionFisicaDTO,
        UUID,
        CrearExploracionFisicaDTO,
        ActualizarExploracionFisicaDTO> {
}