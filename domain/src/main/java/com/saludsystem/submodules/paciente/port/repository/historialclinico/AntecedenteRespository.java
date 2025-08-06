package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;

import java.util.UUID;

public interface AntecedenteRespository {
    Antecedente save(Antecedente antecedente);
    Antecedente update(UUID uuid, Antecedente antecedente);
    void delete(UUID uuid);
}