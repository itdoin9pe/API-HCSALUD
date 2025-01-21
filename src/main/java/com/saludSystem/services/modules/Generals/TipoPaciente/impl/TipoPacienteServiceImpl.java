package com.saludSystem.services.modules.Generals.TipoPaciente.impl;

import com.saludSystem.dtos.Generals.TipoPacienteDTO;
import com.saludSystem.entities.TipoPaciente;
import com.saludSystem.repositories.modules.Generals.TipoPacienteRepository;
import com.saludSystem.services.modules.Generals.TipoPaciente.TipoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoPacienteServiceImpl implements TipoPacienteService {

    private final TipoPacienteRepository tipoPacienteRepository;

    @Autowired
    public TipoPacienteServiceImpl(TipoPacienteRepository tipoPacienteRepository) {
        this.tipoPacienteRepository = tipoPacienteRepository;
    }

    @Override
    public List<TipoPacienteDTO> getTipoPacienteList() {
        return tipoPacienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TipoPacienteDTO convertToDTO(TipoPaciente tipoPaciente) {
        TipoPacienteDTO tipoPacienteDTO = new TipoPacienteDTO();
        tipoPacienteDTO.setTipoPacienteId(tipoPaciente.getTipoPacienteId());
        tipoPacienteDTO.setNombre(tipoPaciente.getNombre());
        return tipoPacienteDTO;
    }

}
