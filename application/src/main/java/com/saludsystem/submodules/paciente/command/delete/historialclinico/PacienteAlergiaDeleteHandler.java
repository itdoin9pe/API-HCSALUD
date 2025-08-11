package com.saludsystem.submodules.paciente.command.delete.historialclinico;

import com.saludsystem.submodules.paciente.service.historia.historialclinico.pacientealergia.PacienteAlergiaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteAlergiaDeleteHandler {

    private final PacienteAlergiaDeleteService pacienteAlergiaDeleteService;

    public PacienteAlergiaDeleteHandler(PacienteAlergiaDeleteService pacienteAlergiaDeleteService) {
        this.pacienteAlergiaDeleteService = pacienteAlergiaDeleteService;
    }

    public void execute(UUID uuid) {

        pacienteAlergiaDeleteService.execute(uuid);

    }

}
