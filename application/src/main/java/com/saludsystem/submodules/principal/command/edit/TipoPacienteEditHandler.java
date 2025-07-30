package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.dtos.put.ActualizarTipoPacienteDTO;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteEditService;
import org.springframework.stereotype.Component;

@Component
public class TipoPacienteEditHandler {

    private final TipoPacienteEditService tipoPacienteEditService;

    public TipoPacienteEditHandler(TipoPacienteEditService tipoPacienteEditService) {
        this.tipoPacienteEditService = tipoPacienteEditService;
    }

    public void execute(Long id, ActualizarTipoPacienteDTO dto) {
        tipoPacienteEditService.execute(id, dto);
    }

}
