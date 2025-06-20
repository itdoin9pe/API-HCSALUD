package com.saludSystem.application.services.Catalogo;

import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoCitadoDTO;
import com.saludSystem.application.services.GenericService;

import java.util.UUID;

public interface TipoCitadoService extends GenericService<
        TipoCitadoDTO,
        UUID,
        CrearTipoCitadoDTO,
        ActualizarTipoCitadoDTO> {
}
