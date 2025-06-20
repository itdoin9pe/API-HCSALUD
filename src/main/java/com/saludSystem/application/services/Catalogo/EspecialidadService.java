package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.EspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarEspecialidadDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface EspecialidadService extends GenericService<
        EspecialidadDTO,
        UUID,
        CrearEspecialidadDTO,
        ActualizarEspecialidadDTO> {
}