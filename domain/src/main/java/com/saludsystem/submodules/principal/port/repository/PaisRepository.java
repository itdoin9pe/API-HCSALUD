package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.Pais;

public interface PaisRepository {
    Pais save(Pais pais);
    Pais update(Integer id, Pais pais);
    void delete(Integer id);
}