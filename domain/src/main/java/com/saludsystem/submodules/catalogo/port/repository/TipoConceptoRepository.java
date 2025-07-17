package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;

import java.util.List;
import java.util.UUID;

public interface TipoConceptoRepository {
    TipoConcepto save(TipoConcepto tipoConcepto);
    TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto);
    void delete(UUID uuid);
    TipoConcepto findById(UUID uuid);
    List<TipoConcepto> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}