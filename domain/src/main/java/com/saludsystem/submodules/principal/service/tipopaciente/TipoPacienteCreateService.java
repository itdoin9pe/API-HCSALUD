package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;

public class TipoPacienteCreateService {

    private final TipoPacienteRepository tipoPacienteRepository;

    public TipoPacienteCreateService(TipoPacienteRepository tipoPacienteRepository) {
        this.tipoPacienteRepository = tipoPacienteRepository;
    }

    public TipoPaciente execute(TipoPaciente tipoPaciente) {

        return tipoPacienteRepository.save(tipoPaciente);

    }

}
