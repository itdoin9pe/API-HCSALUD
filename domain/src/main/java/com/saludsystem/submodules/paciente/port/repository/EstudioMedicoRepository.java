package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;

import java.util.UUID;

public interface EstudioMedicoRepository {

    EstudioMedico save(EstudioMedico tipoTarjeta);
    EstudioMedico update(UUID uuid, EstudioMedico tipoTarjeta);
    void delete(UUID uuid);

}