package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;

import java.util.List;
import java.util.UUID;

public interface ExploracionFisicaDao {
    ExploracionFisica save(ExploracionFisica exploracionFisica);
    ExploracionFisica update(UUID uuid, ExploracionFisica exploracionFisica);
    void delete(UUID uuid);
    ExploracionFisica getById(UUID uuid);
    List<ExploracionFisica> getAll(UUID hospitalId, int page, int rows);
}