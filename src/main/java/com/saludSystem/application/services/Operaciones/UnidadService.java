package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.GET.UnidadDTO;

import java.util.UUID;

public interface UnidadService  extends GenericService<
        UnidadDTO,
        UUID,
        CrearUnidadDTO,
        ActualizarUnidadDTO> {
}