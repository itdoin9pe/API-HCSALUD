package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.Diagnostico;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoDao {
    Diagnostico save(Diagnostico diagnostico);
    Diagnostico update(UUID uuid, Diagnostico diagnostico);
    void delete(UUID uuid);
    Diagnostico getById(UUID uuid);
    List<Diagnostico> getAll(UUID hospitalId, int page, int rows);
}