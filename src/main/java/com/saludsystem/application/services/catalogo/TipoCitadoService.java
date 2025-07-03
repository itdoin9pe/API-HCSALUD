package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.post.CrearTipoCitadoDTO;
import com.saludsystem.application.dtos.catalogo.get.TipoCitadoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarTipoCitadoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoCitadoService extends GenericService<
        TipoCitadoDTO,
        UUID,
        CrearTipoCitadoDTO,
        ActualizarTipoCitadoDTO> {
}
