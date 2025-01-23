package com.saludSystem.services.modules.Generals.InformacionClinica.impl;

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
    public Optional<InformacionClinicaDTO> getInformacionClinicaById(UUID id) {
        return informacionClinicaRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public void deleteInformacionClinica(UUID id) {
        informacionClinicaRepository.deleteById(id);
    }

    @Override
    public InformacionClinicaDTO updateInformacionClinica(UUID id, InformacionClinicaDTO informacionClinicaDTO) {
        InformacionClinica informacionClinica = informacionClinicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InformacionClinica no encontrada con ID: " + id));
        Optional.ofNullable(informacionClinicaDTO.getNombre()).filter(desc -> !desc.isBlank())
                .ifPresent(informacionClinica::setNombre);
        Optional.ofNullable(informacionClinicaDTO.getEstado()).ifPresent(informacionClinica::setEstado);
        InformacionClinica updatedInformacionClinica = informacionClinicaRepository.save(informacionClinica);
        return convertToDTO(updatedInformacionClinica);
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinica informacionClinica) {
        return modelMapper.map(informacionClinica, InformacionClinicaDTO.class);
    }

}
