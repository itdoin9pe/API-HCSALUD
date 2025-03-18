package com.saludSystem.Generals.adapter.TipoPaciente.aplicacion.services.impl;

import com.saludSystem.Generals.adapter.TipoPaciente.aplicacion.TipoPacienteDTO;
import com.saludSystem.Generals.adapter.TipoPaciente.aplicacion.services.TipoPacienteService;
import com.saludSystem.Generals.adapter.TipoPaciente.domain.TipoPacienteModel;
import com.saludSystem.Generals.adapter.TipoPaciente.infraestructura.repositories.TipoPacienteRepository;
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

    private TipoPacienteDTO convertToDTO(TipoPacienteModel tipoPaciente) {
        return modelMapper.map(tipoPaciente, TipoPacienteDTO.class);
    }

}