package com.saludsystem.submodules.catalogo.port.out.repository;

import com.saludsystem.submodules.catalogo.model.TipoCitado;

import java.util.List;
import java.util.UUID;

public interface TipoCitadoRepositoryPort {
    TipoCitado save(TipoCitado tipoCitado);
    TipoCitado update(UUID uuid, TipoCitado tipoCitado);
    void delete(UUID uuid);
    TipoCitado findById(UUID uuid);
    List<TipoCitado> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}