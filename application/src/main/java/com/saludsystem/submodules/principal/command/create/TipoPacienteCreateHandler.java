package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.model.dtos.post.CrearTipoPacienteDTO;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoPacienteCreateHandler {

    private final TipoPacienteCreateService tipoPacienteCreateService;

    public TipoPacienteCreateHandler(TipoPacienteCreateService tipoPacienteCreateService) {
        this.tipoPacienteCreateService = tipoPacienteCreateService;
    }

    public void execute(CrearTipoPacienteDTO dto) {
        tipoPacienteCreateService.execute(dto);
    }

}
