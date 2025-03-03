package com.saludSystem.aplicacion.services.modules.Catalogo.Medida.impl;
/*
import com.saludSystem.dtos.catalago.Medida.ActualizarMedidaDTO;
import com.saludSystem.dtos.catalago.Medida.CrearMedidaDTO;
import com.saludSystem.dtos.catalago.Medida.MedidaDTO;
import com.saludSystem.entities.catalogo.Medida;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Catalogo.MedidaRepository;
import com.saludSystem.services.modules.Catalogo.Medida.MedidaService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedidaServiceImpl implements MedidaService {

    private final MedidaRepository medidaRepository;
    private final ModelMapper modelMapper;

    public MedidaServiceImpl(MedidaRepository medidaRepository, ModelMapper modelMapper) {
        this.medidaRepository = medidaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearMedidaDTO saveMedida(CrearMedidaDTO crearMedidaDTO) {
        Medida medida = modelMapper.map(crearMedidaDTO, Medida.class);
        medidaRepository.save(medida);
        return modelMapper.map(medida, CrearMedidaDTO.class);
    }

    @Override
    public List<MedidaDTO> getMedidaList() {
        return medidaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MedidaDTO> getMedidaById(UUID medidaId) {
        return Optional.ofNullable(medidaRepository.findById(medidaId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Medida no encontrada con ID" + medidaId)));
    }

    @Override
    public ActualizarMedidaDTO updateMedida(UUID medidaId, ActualizarMedidaDTO actualizarMedidaDTO) {
        Medida medida = medidaRepository.findById(medidaId).orElseThrow(
                () -> new ResourceNotFoundException("Medida no encontrada con ID" + medidaId));
        Optional.ofNullable(actualizarMedidaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(medida::setNombre);
        Optional.ofNullable(actualizarMedidaDTO.getEstado()).ifPresent(medida::setEstado);
        medidaRepository.save(medida);
        return modelMapper.map(medida, ActualizarMedidaDTO.class);
    }

    @Override
    public void deleteMedida(UUID medidaId) {
        Medida medida = medidaRepository.findById(medidaId)
                .orElseThrow(() -> new ResourceNotFoundException("Medida no econtrada con Id" + medidaId));
        medidaRepository.delete(medida);
    }

    @Override
    public long getTotalCount() {
        return medidaRepository.count();
    }

    private MedidaDTO convertToDTO(Medida medida) {
        return modelMapper.map(medida, MedidaDTO.class);
    }
}


 */