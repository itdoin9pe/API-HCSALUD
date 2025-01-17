package com.saludSystem.services.modules.Generals.Aseguradoras.impl;

import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.entities.Aseguradora;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.AseguradoraRepository;
import com.saludSystem.services.modules.Generals.Aseguradoras.AseguradoraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AseguradoraServiceImpl implements AseguradoraService {
    
    private final AseguradoraRepository aseguradoraRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AseguradoraServiceImpl(AseguradoraRepository aseguradoraRepository, ModelMapper modelMapper) {
        this.aseguradoraRepository = aseguradoraRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AseguradoraDTO saveAseguradora(AseguradoraDTO aseguradoraDTO) {
        Aseguradora aseguradora = new Aseguradora();
        aseguradora.setDescripcion(aseguradoraDTO.getDescripcion());
        aseguradora.setEstado(aseguradoraDTO.getEstado());
        Aseguradora savedAseguradora = aseguradoraRepository.save(aseguradora);
        return convertToDTO(savedAseguradora);
    }

    @Override
    public List<AseguradoraDTO> getAllAseguradoras(int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Aseguradora> aseguradorasPage = aseguradoraRepository.findAll(pageable);
        return aseguradorasPage.getContent().stream()
                .map(aseguradora -> modelMapper.map(aseguradora, AseguradoraDTO.class))
                .toList();
    }

    @Override
    public List<AseguradoraDTO> getAseguradoraList() {
        return aseguradoraRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AseguradoraDTO> getAseguradoraById(int aseguradoraId) {
        return Optional.ofNullable(aseguradoraRepository.findById(aseguradoraId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Aseguradora no encontrada con ID" + aseguradoraId)));
    }

    @Override
    public AseguradoraDTO updateAseguradora(int aseguradoraId, AseguradoraDTO aseguradoraDTO) {
        Aseguradora aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new ResourceNotFoundException("Aseguradora no encontrada con ID: " + aseguradoraId));

        // Actualiza campo descripción si está presente
        Optional.ofNullable(aseguradoraDTO.getDescripcion()).filter(desc -> !desc.isBlank()) // Evita valores vacíos
                .ifPresent(aseguradora::setDescripcion);

        // Actualiza campo estado si está presente
        Optional.ofNullable(aseguradoraDTO.getEstado()).ifPresent(aseguradora::setEstado);

        Aseguradora updatedAseguradora = aseguradoraRepository.save(aseguradora);
        return convertToDTO(updatedAseguradora);
    }

    @Override
    public void deleteAseguradora(int aseguradoraId) {
        Aseguradora aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada con ID: " + aseguradoraId));
        aseguradoraRepository.delete(aseguradora);
    }

    @Override
    public long getTotalCount() {
        return aseguradoraRepository.count();
    }

    private AseguradoraDTO convertToDTO(Aseguradora aseguradora) {
        AseguradoraDTO dto = new AseguradoraDTO();
        dto.setAseguradoraId(aseguradora.getId());
        dto.setDescripcion(aseguradora.getDescripcion());
        dto.setEstado(aseguradora.isEstado());
        return dto;
    }
}
