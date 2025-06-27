package com.saludSystem.application.services.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
import java.util.UUID;

public interface PresentacionService extends GenericService<
        PresentacionDTO,
        UUID,
        CrearPresentacionDTO,
        ActualizarPresentacionDTO> {
}