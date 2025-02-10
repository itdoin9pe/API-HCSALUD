package com.saludSystem.services.modules.Generals.Estudios.impl;

import com.saludSystem.dtos.Generals.Estudio.ActualizarEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.CrearEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.EstudioDTO;
import com.saludSystem.entities.Estudio;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.EstudioRepository;
import com.saludSystem.services.modules.Generals.Estudios.EstudioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstudioServiceImpl implements EstudioService {

    private final EstudioRepository estudioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EstudioServiceImpl(EstudioRepository estudioRepository, ModelMapper modelMapper) {
        this.estudioRepository = estudioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearEstudioDTO saveEstudio(CrearEstudioDTO crearEstudioDTO) {
        Estudio estudio = modelMapper.map(crearEstudioDTO, Estudio.class);
        estudioRepository.save(estudio);
        return modelMapper.map(estudio, CrearEstudioDTO.class);
    }

    @Override
    public void deleteEstudio(UUID estudioId) {
        Estudio estudio = estudioRepository.findById(estudioId)
                        .orElseThrow(() -> new RuntimeException("Estudio no encontrado con ID: " + estudioId));
        estudioRepository.deleteById(estudioId);
    }

    @Override
    public ActualizarEstudioDTO updateEstudio(UUID estudioId, ActualizarEstudioDTO actualizarEstudioDTO) {
        Estudio estudio = estudioRepository.findById(estudioId)
                .orElseThrow(() -> new ResourceNotFoundException("Estudio no encontrado con ID: " + estudioId));
        Optional.ofNullable(actualizarEstudioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(estudio::setDescripcion);
        estudioRepository.save(estudio);
        return modelMapper.map(estudio, ActualizarEstudioDTO.class);
    }

    @Override
    public Optional<EstudioDTO> getEstudioById(UUID id) {
        return estudioRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public List<EstudioDTO> getEstudioList() {
        return estudioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long getTotalCount() {
        return estudioRepository.count();
    }

    /*
    @Override
    public List<EstudioDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Estudio> estudiosPage = estudioRepository.findAll(pageable);
        return estudiosPage.getContent().stream()
                .map(estudio -> modelMapper.map(estudio, EstudioDTO.class))
                .toList();
    }*/

    private EstudioDTO convertToDTO(Estudio estudio) {
        return modelMapper.map(estudio, EstudioDTO.class);
    }

}
