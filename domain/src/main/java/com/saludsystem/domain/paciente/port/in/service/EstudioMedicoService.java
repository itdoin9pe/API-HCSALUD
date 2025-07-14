package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.domain.mantenimiento.model.TipoTarjeta;
import com.saludsystem.domain.paciente.model.EstudioMedico;

import java.util.List;
import java.util.UUID;

public interface EstudioMedicoService {

    EstudioMedico save(EstudioMedico tipoTarjeta);
    EstudioMedico update(UUID uuid, EstudioMedico tipoTarjeta);
    void delete(UUID uuid);
    EstudioMedico getById(UUID uuid);
    List<EstudioMedico> getAll(UUID hospitalId, int page, int rows);

}