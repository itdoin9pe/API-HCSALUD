package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.TipoCitado;

import java.util.UUID;

public interface TipoCitadoRepository {
    TipoCitado save(TipoCitado tipoCitado);
    TipoCitado update(UUID uuid, TipoCitado tipoCitado);
    void delete(UUID uuid);
}