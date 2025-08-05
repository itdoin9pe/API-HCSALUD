package com.saludsystem.submodules.configuracion.port.in.repository;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;

import java.util.UUID;

public interface TipoDocumentoRepository {
    TipoDocumento save(TipoDocumento tipoDocumento);
    TipoDocumento update(UUID uuid, TipoDocumento tipoDocumento);
    void delete(UUID uuid);
}