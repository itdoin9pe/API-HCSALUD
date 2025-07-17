package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.TipoConcepto;

import java.util.List;
import java.util.UUID;

public interface TipoConceptoDao {
    TipoConcepto save(TipoConcepto tipoConcepto);
    TipoConcepto update(UUID uuid, TipoConcepto tipoConcepto);
    void delete(UUID uuid);
    TipoConcepto getById(UUID uuid);
    List<TipoConcepto> getAll(UUID hospitalId, int page, int rows);
}