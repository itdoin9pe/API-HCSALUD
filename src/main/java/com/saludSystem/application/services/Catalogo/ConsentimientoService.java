package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.ConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarConsentimientoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface ConsentimientoService extends GenericService<
        ConsentimientoDTO,
        UUID,
        CrearConsentimientoDTO,
        ActualizarConsentimientoDTO> {
}