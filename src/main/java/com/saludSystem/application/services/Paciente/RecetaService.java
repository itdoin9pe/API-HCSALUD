package com.saludSystem.application.services.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.RecetaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearRecetaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarRecetaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface RecetaService extends GenericService<
        RecetaDTO,
        UUID,
        CrearRecetaDTO,
        ActualizarRecetaDTO> {
}