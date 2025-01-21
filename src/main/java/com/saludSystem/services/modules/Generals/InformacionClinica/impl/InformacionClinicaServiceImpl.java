package com.saludSystem.services.modules.Generals.InformacionClinica.impl;

import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.InformacionClinicaRepository;
import com.saludSystem.services.modules.Generals.InformacionClinica.InformacionClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InformacionClinicaServiceImpl implements InformacionClinicaService {

    private final InformacionClinicaRepository informacionClinicaRepository;

    @Autowired
    public InformacionClinicaServiceImpl(InformacionClinicaRepository informacionClinicaRepository) {
        this.informacionClinicaRepository = informacionClinicaRepository;
    }

    @Override
    public List<InformacionClinicaDTO> getInformacionClinicaList() {
        return informacionClinicaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InformacionClinicaDTO saveInformacionClinica(InformacionClinicaDTO informacionClinicaDTO) {
        InformacionClinica informacionClinica = new InformacionClinica();
        informacionClinica.setNombre(informacionClinicaDTO.getNombre());
        informacionClinica.setEstado(informacionClinicaDTO.getEstado());
        InformacionClinica savedInformacionClinica = informacionClinicaRepository.save(informacionClinica);
        return convertToDTO(savedInformacionClinica);
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
        informacionClinica.setNombre(informacionClinicaDTO.getNombre());
        informacionClinica.setEstado(informacionClinicaDTO.getEstado());
        InformacionClinica updatedInformacionClinica = informacionClinicaRepository.save(informacionClinica);
        return convertToDTO(updatedInformacionClinica);
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinica informacionClinica) {
        InformacionClinicaDTO informacionClinicaDTO = new InformacionClinicaDTO();
        informacionClinicaDTO.setId(informacionClinica.getId());
        informacionClinicaDTO.setNombre(informacionClinica.getNombre());
        informacionClinicaDTO.setEstado(informacionClinica.getEstado());
        return informacionClinicaDTO;
    }

}
