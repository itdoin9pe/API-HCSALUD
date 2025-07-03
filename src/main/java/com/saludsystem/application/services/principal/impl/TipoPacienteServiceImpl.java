package com.saludsystem.application.services.principal.impl;


import com.saludsystem.application.dtos.principal.get.TipoPacienteDTO;
import com.saludsystem.application.services.principal.TipoPacienteService;
import com.saludsystem.domain.model.principal.TipoPacienteEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.principal.TipoPacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return tipoPacienteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TipoPacienteDTO convertToDTO(TipoPacienteEntity tipoPaciente) {
        return modelMapper.map(tipoPaciente, TipoPacienteDTO.class);
    }

}