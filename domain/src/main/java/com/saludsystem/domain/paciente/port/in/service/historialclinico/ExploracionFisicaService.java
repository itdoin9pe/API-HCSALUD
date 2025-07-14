package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.domain.paciente.model.historialclinico.ExploracionFisica;

import java.util.List;
import java.util.UUID;

public interface ExploracionFisicaService {
    ExploracionFisica save(ExploracionFisica exploracionFisica);
    ExploracionFisica update(UUID uuid, ExploracionFisica exploracionFisica);
    void delete(UUID uuid);
    ExploracionFisica getById(UUID uuid);
    List<ExploracionFisica> getAll(UUID hospitalId, int page, int rows);
}