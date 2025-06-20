package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.TipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoConceptoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface TipoConceptoService extends GenericService<
        TipoConceptoDTO,
        UUID,
        CrearTipoConceptoDTO,
        ActualizarTipoConceptoDTO> {
}