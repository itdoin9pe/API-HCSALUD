package com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia;

import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.PacienteAlergiaRepository;

import java.util.UUID;

public class PacienteAlergiaDeleteService {

    private final PacienteAlergiaRepository pacienteAlergiaRepository;
    private final PacienteAlergiaDao pacienteAlergiaDao;

    public PacienteAlergiaDeleteService(PacienteAlergiaRepository pacienteAlergiaRepository, PacienteAlergiaDao pacienteAlergiaDao) {
        this.pacienteAlergiaRepository = pacienteAlergiaRepository;
        this.pacienteAlergiaDao = pacienteAlergiaDao;
    }

    public void execute(UUID uuid) {

        var pacienteAlergia = pacienteAlergiaDao.getById(uuid);

        if (pacienteAlergia.getEstado() != null && pacienteAlergia.getEstado() == 0) {

            throw new IllegalStateException("No se puede eliminar una alergia del paciente desactivada");

        }

        pacienteAlergiaRepository.delete(uuid);

    }

}
