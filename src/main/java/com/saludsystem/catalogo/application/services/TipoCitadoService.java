package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.req.CrearTipoCitadoDTO;
import com.saludsystem.catalogo.application.dtos.res.TipoCitadoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoCitadoService extends GenericService<
        CrearTipoCitadoDTO,
        TipoCitadoDTO,
        UUID> {
}