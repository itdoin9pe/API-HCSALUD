package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedidaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedidaDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedidaDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface MedidaService extends GenericService<
        MedidaDTO,
        UUID,
        CrearMedidaDTO,
        ActualizarMedidaDTO> {
}