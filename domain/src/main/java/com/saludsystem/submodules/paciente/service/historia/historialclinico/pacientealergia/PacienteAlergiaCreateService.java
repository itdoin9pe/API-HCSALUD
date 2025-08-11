package com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.PacienteAlergia;
import com.saludsystem.submodules.paciente.port.repository.historialclinico.PacienteAlergiaRepository;

public class PacienteAlergiaCreateService {

    private final PacienteAlergiaRepository pacienteAlergiaRepository;

    public PacienteAlergiaCreateService(PacienteAlergiaRepository pacienteAlergiaRepository) {
        this.pacienteAlergiaRepository = pacienteAlergiaRepository;
    }

    public PacienteAlergia execute(PacienteAlergia pacienteAlergia) {

        return pacienteAlergiaRepository.save(pacienteAlergia);

    }

}
