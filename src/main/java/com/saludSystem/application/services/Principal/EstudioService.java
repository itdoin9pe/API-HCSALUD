package com.saludSystem.application.services.Principal;

import com.saludSystem.application.dtos.Principal.GET.EstudioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEstudioDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarEstudioDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface EstudioService extends GenericService<
        EstudioDTO,
        UUID,
        CrearEstudioDTO,
        ActualizarEstudioDTO> {
}