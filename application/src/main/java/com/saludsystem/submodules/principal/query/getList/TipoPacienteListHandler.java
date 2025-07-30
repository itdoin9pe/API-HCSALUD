package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.dtos.get.TipoPacienteDTO;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoPacienteListHandler {

    private final TipoPacienteListService tipoPacienteListService;

    public TipoPacienteListHandler(TipoPacienteListService tipoPacienteListService) {
        this.tipoPacienteListService = tipoPacienteListService;
    }

    public List<TipoPacienteDTO> execute() {
        return tipoPacienteListService.execute();
    }

}
