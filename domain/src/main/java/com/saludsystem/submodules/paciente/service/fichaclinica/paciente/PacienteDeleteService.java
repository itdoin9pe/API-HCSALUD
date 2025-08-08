package com.saludsystem.submodules.paciente.service.fichaclinica.paciente;

import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import com.saludsystem.submodules.paciente.port.repository.PacienteRepository;

import java.util.UUID;

public class PacienteDeleteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteDao pacienteDao;

    public PacienteDeleteService(PacienteRepository pacienteRepository, PacienteDao pacienteDao) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteDao = pacienteDao;
    }

    public void execute(UUID uuid) {

        var paciente = pacienteDao.getById(uuid);

        if (paciente.getEstado() != null) {

            throw new IllegalStateException("No se puede eliminar un paciente inactivo");

        }

        pacienteRepository.delete(uuid);

    }

}
