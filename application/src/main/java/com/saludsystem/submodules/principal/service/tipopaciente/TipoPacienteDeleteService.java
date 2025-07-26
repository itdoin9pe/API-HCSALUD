package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;

public class TipoPacienteDeleteService {

    private final TipoPacienteRepository tipoPacienteRepository;

    public TipoPacienteDeleteService(TipoPacienteRepository tipoPacienteRepository) {
        this.tipoPacienteRepository = tipoPacienteRepository;
    }

    public void execute(Long id) {
        tipoPacienteRepository.delete(id);
    }

}
