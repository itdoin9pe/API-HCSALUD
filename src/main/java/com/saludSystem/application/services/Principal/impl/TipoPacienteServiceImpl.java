package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.dtos.Principal.GET.TipoPacienteDTO;
import com.saludSystem.application.services.Principal.TipoPacienteService;
import com.saludSystem.domain.model.Principal.TipoPacienteEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.TipoPacienteRepository;
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