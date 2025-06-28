package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.GET.AseguradoraDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearAseguradoraDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarAseguradoraDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface AseguradoraService extends GenericService<
        AseguradoraDTO,
        UUID,
        CrearAseguradoraDTO,
        ActualizarAseguradoraDTO> {
}