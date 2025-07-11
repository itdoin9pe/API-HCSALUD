package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.TipoCitado;

import java.util.List;
import java.util.UUID;

public interface TipoCitadoService {
    TipoCitado save(TipoCitado tipoCitado);
    TipoCitado update(UUID uuid, TipoCitado tipoCitado);
    void delete(UUID uuid);
    TipoCitado getById(UUID uuid);
    List<TipoCitado> getAll(UUID hospitalId, int page, int rows);
}