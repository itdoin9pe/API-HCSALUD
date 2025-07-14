package com.saludsystem.submodules.principal.port.in.service;

import com.saludsystem.submodules.principal.model.Estudio;

import java.util.List;
import java.util.UUID;

public interface EstudioService {
    Estudio save(Estudio tipoCitado);
    Estudio update(UUID uuid, Estudio tipoCitado);
    void delete(UUID uuid);
    Estudio getById(UUID uuid);
    List<Estudio> getAll(UUID hospitalId, int page, int rows);
}