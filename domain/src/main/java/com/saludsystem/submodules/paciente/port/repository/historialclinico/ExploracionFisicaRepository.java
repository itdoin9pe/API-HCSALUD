package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;

import java.util.UUID;

public interface ExploracionFisicaRepository {
    ExploracionFisica save(ExploracionFisica exploracionFisica);
    ExploracionFisica update(UUID uuid, ExploracionFisica exploracionFisica);
    void delete(UUID uuid);
}