package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.get.TipoPacienteDTO;
import com.saludsystem.principal.application.service.TipoPacienteService;
import com.saludsystem.principal.domain.model.TipoPacienteEntity;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.TipoPacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPacienteServiceImpl implements TipoPacienteService {

    private final TipoPacienteRepository tipoPacienteRepository;
    private final ModelMapper modelMapper;

    public TipoPacienteServiceImpl(TipoPacienteRepository tipoPacienteRepository, ModelMapper modelMapper) {
        this.tipoPacienteRepository = tipoPacienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoPacienteDTO> getTipoPacienteList() {
        return tipoPacienteRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    private TipoPacienteDTO convertToDTO(TipoPacienteEntity tipoPaciente) {
        return modelMapper.map(tipoPaciente, TipoPacienteDTO.class);
    }

}