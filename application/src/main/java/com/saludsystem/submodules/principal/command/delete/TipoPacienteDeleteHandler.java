package com.saludsystem.submodules.principal.command.delete;

import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteDeleteService;
import org.springframework.stereotype.Component;

@Component
public class TipoPacienteDeleteHandler {

    private final TipoPacienteDeleteService tipoPacienteDeleteService;

    public TipoPacienteDeleteHandler(TipoPacienteDeleteService tipoPacienteDeleteService) {
        this.tipoPacienteDeleteService = tipoPacienteDeleteService;
    }

    public void execute(Long id) {
        tipoPacienteDeleteService.execute(id);
    }

}
