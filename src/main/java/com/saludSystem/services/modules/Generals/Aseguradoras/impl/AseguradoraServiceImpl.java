package com.saludSystem.services.modules.Generals.Aseguradoras.impl;

import com.saludSystem.dtos.Generals.Aseguradora.AseguradoraDTO;
import com.saludSystem.dtos.Generals.Aseguradora.CrearAseguradoraDTO;
import com.saludSystem.entities.Aseguradora;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.AseguradoraRepository;
import com.saludSystem.services.modules.Generals.Aseguradoras.AseguradoraService;
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
public class AseguradoraServiceImpl implements AseguradoraService {
    
    private final AseguradoraRepository aseguradoraRepository;
    private final ModelMapper modelMapper;

    public AseguradoraServiceImpl(AseguradoraRepository aseguradoraRepository, ModelMapper modelMapper) {
        this.aseguradoraRepository = aseguradoraRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearAseguradoraDTO saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO) {
        Aseguradora aseguradora = new Aseguradora();
        aseguradora.setDescripcion(crearAseguradoraDTO.getDescripcion());
        aseguradora.setEstado(crearAseguradoraDTO.getEstado());
        Aseguradora savedAseguradora = aseguradoraRepository.save(aseguradora);
        return convertToCrearAseguradoraDTO(savedAseguradora);
    }

    @Override
    public List<AseguradoraDTO> getAseguradoraList() {
        return aseguradoraRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AseguradoraDTO> getAseguradoraById(UUID aseguradoraId) {
        return Optional.ofNullable(aseguradoraRepository.findById(aseguradoraId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Aseguradora no encontrada con ID" + aseguradoraId)));
    }

    @Override
    public AseguradoraDTO updateAseguradora(UUID aseguradoraId, AseguradoraDTO aseguradoraDTO) {
        Aseguradora aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new ResourceNotFoundException("Aseguradora no encontrada con ID: " + aseguradoraId));
        Optional.ofNullable(aseguradoraDTO.getDescripcion()).filter(desc -> !desc.isBlank()) // Evita valores vacíos
                .ifPresent(aseguradora::setDescripcion);
        Optional.ofNullable(aseguradoraDTO.getEstado()).ifPresent(aseguradora::setEstado);
        Aseguradora updatedAseguradora = aseguradoraRepository.save(aseguradora);
        return convertToDTO(updatedAseguradora);
    }

    @Override
    public void deleteAseguradora(UUID aseguradoraId) {
        Aseguradora aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada con ID: " + aseguradoraId));
        aseguradoraRepository.delete(aseguradora);
    }

    @Override
    public long getTotalCount() {
        return aseguradoraRepository.count();
    }

    @Override
    public List<AseguradoraDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Aseguradora> aseguradorasPage = aseguradoraRepository.findAll(pageable);
        return aseguradorasPage.getContent().stream()
                .map(aseguradora -> modelMapper.map(aseguradora, AseguradoraDTO.class))
                .toList();
    }

    private AseguradoraDTO convertToDTO(Aseguradora aseguradora) {
        return modelMapper.map(aseguradora, AseguradoraDTO.class);
    }

    private CrearAseguradoraDTO convertToCrearAseguradoraDTO(Aseguradora aseguradora) {
        return modelMapper.map(aseguradora, CrearAseguradoraDTO.class);
    }

}