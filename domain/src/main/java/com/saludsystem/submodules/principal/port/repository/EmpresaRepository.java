package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.Empresa;

import java.util.UUID;

public interface EmpresaRepository {
    Empresa save(Empresa empresa);
    Empresa update(UUID uuid, Empresa empresa);
    void delete(UUID uuid);
}