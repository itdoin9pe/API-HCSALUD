package com.saludSystem.application.services.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.AntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearAntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarAntecedenteDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface AntecedenteService extends GenericService<
        AntecedenteDTO,
        UUID,
        CrearAntecedenteDTO,
        ActualizarAntecedenteDTO> {
}