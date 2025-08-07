package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;

import java.util.UUID;

public interface EstudioMedicoRepository {

    EstudioMedico save(EstudioMedico estudioMedico);
    EstudioMedico update(Long id, EstudioMedico estudioMedico);
    void delete(Long uuid);

}