package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;

import java.util.List;
import java.util.UUID;

public interface EstudioMedicoDao {

    EstudioMedico save(EstudioMedico tipoTarjeta);
    EstudioMedico update(UUID uuid, EstudioMedico tipoTarjeta);
    void delete(UUID uuid);
    EstudioMedico getById(UUID uuid);
    List<EstudioMedico> getAll(UUID hospitalId, int page, int rows);

}