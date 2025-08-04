package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;

import java.util.List;
import java.util.UUID;

public interface TipoDocumentoRepository {
    TipoDocumento save(TipoDocumento tipoDocumento);
    TipoDocumento update(UUID uuid, TipoDocumento tipoDocumento);
    void delete(UUID uuid);
    TipoDocumento getById(UUID uuid);
    List<TipoDocumento> getAll(UUID hospitalId, int page, int rows);
}