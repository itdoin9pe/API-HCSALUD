package com.saludSystem.application.services.Cita;

import com.saludSystem.application.dtos.Cita.GET.CitaDTO;
import com.saludSystem.application.dtos.Cita.POST.CrearCitaDTO;
import com.saludSystem.application.dtos.Cita.PUT.ActualizarCitaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface CitaService extends GenericService<
        CitaDTO,
        UUID,
        CrearCitaDTO,
        ActualizarCitaDTO> {
}