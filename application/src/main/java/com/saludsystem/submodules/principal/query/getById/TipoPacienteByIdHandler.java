package com.saludsystem.submodules.principal.query.getById;

import com.saludsystem.submodules.principal.model.dtos.get.TipoPacienteDTO;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteByIdService;
import org.springframework.stereotype.Component;

@Component
public class TipoPacienteByIdHandler {

    private final TipoPacienteByIdService tipoPacienteByIdService;

    public TipoPacienteByIdHandler(TipoPacienteByIdService tipoPacienteByIdService) {
        this.tipoPacienteByIdService = tipoPacienteByIdService;
    }

    public TipoPacienteDTO execute(Long id) {
        return tipoPacienteByIdService.execute(id);
    }

}
