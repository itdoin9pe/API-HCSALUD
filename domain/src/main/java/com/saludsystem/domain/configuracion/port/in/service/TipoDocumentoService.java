package com.saludsystem.domain.configuracion.port.in.service;

import com.saludsystem.domain.configuracion.model.TipoDocumento;

import java.util.List;
import java.util.UUID;

public interface TipoDocumentoService {
    TipoDocumento save(TipoDocumento tipoDocumento);
    TipoDocumento update(UUID uuid, TipoDocumento tipoDocumento);
    void delete(UUID uuid);
    TipoDocumento getById(UUID uuid);
    List<TipoDocumento> getAll(UUID hospitalId, int page, int rows);
}