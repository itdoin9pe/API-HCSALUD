package com.saludsystem.application.services.catalogo;

import com.saludsystem.application.dtos.catalogo.post.CrearTipoCitadoDTO;
import com.saludsystem.application.dtos.catalogo.req.TipoCitadoDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface TipoCitadoService extends GenericService<
        CrearTipoCitadoDTO,
        TipoCitadoDTO,
        UUID> {
}