package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarAlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.GET.AlergiaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearAlergiaDTO;

import java.util.UUID;

public interface AlergiaService extends GenericService<
        AlergiaDTO,
        UUID,
        CrearAlergiaDTO,
        ActualizarAlergiaDTO> {
}