package com.saludsystem.submodules.principal.service.tipopaciente;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.model.dtos.put.ActualizarTipoPacienteDTO;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;

public class TipoPacienteEditService {

    private final TipoPacienteRepository tipoPacienteRepository;

    public TipoPacienteEditService(TipoPacienteRepository tipoPacienteRepository) {
        this.tipoPacienteRepository = tipoPacienteRepository;
    }

    public TipoPaciente execute(Long id, ActualizarTipoPacienteDTO dto) {
        var tipoPacUpdate = TipoPacienteMapper.fromUpdateDto(id, dto);
        return tipoPacienteRepository.update(id, tipoPacUpdate);
    }
}
