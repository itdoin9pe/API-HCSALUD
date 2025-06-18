package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.ApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearApoderadoDTO;
import com.saludSystem.application.services.GenericService;
import java.util.UUID;

public interface ApoderadoService extends GenericService<
        ApoderadoDTO,
        UUID,
        CrearApoderadoDTO,
        CrearApoderadoDTO> {
}