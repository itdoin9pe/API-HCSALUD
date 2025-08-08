package com.saludsystem.submodules.paciente.command.delete;

import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PacienteDeleteHandler {

    private final PacienteDeleteService pacienteDeleteService;

    public PacienteDeleteHandler(PacienteDeleteService pacienteDeleteService) {
        this.pacienteDeleteService = pacienteDeleteService;
    }

    public void execute(UUID uuid) {

        pacienteDeleteService.execute(uuid);

    }

}
