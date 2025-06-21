package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.GET.TipoDocumentoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface TipoDocumentoService extends GenericService<
        TipoDocumentoDTO,
        UUID,
        CrearTipoDocumentoDTO,
        ActualizarTipoDocumentoDTO> {
}