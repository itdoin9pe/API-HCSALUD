package com.saludsystem.submodules.principal.port.in.service;

import com.saludsystem.submodules.principal.model.Empresa;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {
    Empresa save(Empresa empresa);
    Empresa update(UUID uuid, Empresa empresa);
    void delete(UUID uuid);
    Empresa getById(UUID uuid);
    List<Empresa> getAll(UUID hospitalId, int page, int rows);
}