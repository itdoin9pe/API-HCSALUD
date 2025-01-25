package com.saludSystem.services.modules.Generals.InformacionClinica.impl;

import com.saludSystem.dtos.Generals.InformacionClinica.ActualizarInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.CrearInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.InformacionClinicaDTO;
import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.InformacionClinicaRepository;
import com.saludSystem.services.modules.Generals.InformacionClinica.InformacionClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InformacionClinicaServiceImpl implements InformacionClinicaService {

    private final InformacionClinicaRepository informacionClinicaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public InformacionClinicaServiceImpl(InformacionClinicaRepository informacionClinicaRepository, ModelMapper modelMapper) {
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<InformacionClinicaDTO> getInformacionClinicaList() {
        return informacionClinicaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CrearInformacionClinicaDTO saveInformacionClinica(CrearInformacionClinicaDTO crearInformacionClinicaDTO) {
        InformacionClinica informacionClinica = modelMapper.map(crearInformacionClinicaDTO, InformacionClinica.class);
        informacionClinicaRepository.save(informacionClinica);
        return modelMapper.map(informacionClinica, CrearInformacionClinicaDTO.class);
    }

    @Override
    public Optional<InformacionClinicaDTO> getInformacionClinicaById(UUID informacionClinicaId) {
        return informacionClinicaRepository.findById(informacionClinicaId)
                .map(this::convertToDTO);
    }

    @Override
    public void deleteInformacionClinica(UUID id) {
        informacionClinicaRepository.deleteById(id);
    }

    @Override
    public ActualizarInformacionClinicaDTO updateInformacionClinica(UUID informacionClinicaId, ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO) {
        InformacionClinica informacionClinica = informacionClinicaRepository.findById(informacionClinicaId)
                .orElseThrow(() -> new ResourceNotFoundException("InformacionClinica no encontrada con ID: " + informacionClinicaId));
        Optional.ofNullable(actualizarInformacionClinicaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(informacionClinica::setNombre);
        Optional.ofNullable(actualizarInformacionClinicaDTO.getEstado()).ifPresent(informacionClinica::setEstado);
        informacionClinicaRepository.save(informacionClinica);
        return modelMapper.map(informacionClinica, ActualizarInformacionClinicaDTO.class);
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinica informacionClinica) {
        return modelMapper.map(informacionClinica, InformacionClinicaDTO.class);
    }

}
