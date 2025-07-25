package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;

import java.util.List;
import java.util.UUID;

public interface AntecedenteDao {
    Antecedente save(Antecedente antecedente);
    Antecedente update(UUID uuid, Antecedente antecedente);
    void delete(UUID uuid);
    Antecedente getById(UUID uuid);
    List<Antecedente> getAll(UUID hospitalId, int page, int rows);
}