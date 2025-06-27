package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;

import java.util.List;
import java.util.UUID;

public interface MarcaService extends GenericService<
        MarcaDTO,
        UUID,
        CrearMarcaDTO,
        ActualizarMarcaDTO> {
}