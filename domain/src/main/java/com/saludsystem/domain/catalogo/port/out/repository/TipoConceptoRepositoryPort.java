package com.saludsystem.domain.catalogo.port.out.repository;

import com.saludsystem.domain.catalogo.model.TipoConcepto;

import java.util.List;
import java.util.UUID;

public interface TipoConceptoRepositoryPort {
    TipoConcepto save(TipoConcepto tipoConcepto);
    TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto);
    void delete(UUID uuid);
    TipoConcepto findById(UUID uuid);
    List<TipoConcepto> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}