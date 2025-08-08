package com.saludsystem.submodules.paciente.service.fichaclinica.paciente;

import com.saludsystem.submodules.paciente.model.constant.PacienteConstant;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import com.saludsystem.submodules.paciente.port.repository.PacienteRepository;

import java.util.UUID;

public class PacienteEditService {

    private final PacienteDao pacienteDao;
    private final PacienteRepository pacienteRepository;

    public PacienteEditService(PacienteDao pacienteDao, PacienteRepository pacienteRepository) {
        this.pacienteDao = pacienteDao;
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente execute(UUID uuid, Paciente paciente) {

        var currentPac = pacienteDao.getById(uuid);

        if (currentPac == null) {

            throw new IllegalArgumentException(PacienteConstant.INVALID_ID);

        }

        if (currentPac.getEstado() != null) {

            throw new IllegalStateException("El paciente se encuentra inactivo");

        }

        return pacienteRepository.update(uuid, paciente);

    }

}
