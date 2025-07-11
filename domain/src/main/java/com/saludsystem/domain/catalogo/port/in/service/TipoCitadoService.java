package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.catalogo.application.dtos.get.TipoCitadoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearTipoCitadoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarTipoCitadoDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface TipoCitadoService extends GenericService<
        TipoCitadoDTO,
        CrearTipoCitadoDTO,
        ActualizarTipoCitadoDTO,
        UUID> {
}