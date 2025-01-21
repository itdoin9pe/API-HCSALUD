package com.saludSystem.services.modules.Generals.Estudios.impl;

import com.saludSystem.dtos.Generals.EstudioDTO;
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
    public EstudioDTO saveEstudio(EstudioDTO estudioDTO) {
        Estudio estudio = new Estudio();
        estudio.setDescripcion(estudioDTO.getDescripcion());
        Estudio savedEstudio = estudioRepository.save(estudio);
        return convertToDTO(savedEstudio);
    }

    @Override
    public List<EstudioDTO> getAllEstudios(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Estudio> estudiosPage = estudioRepository.findAll(pageable);
        return estudiosPage.getContent().stream()
                .map(estudio -> modelMapper.map(estudio, EstudioDTO.class))
                .toList();
    }

    @Override
    public void deleteEstudio(Integer id) {
        Estudio estudio = estudioRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Estudio no encontrado con ID: " + id));
        estudioRepository.deleteById(id);
    }

    @Override
    public EstudioDTO updateEstudio(Integer id, EstudioDTO estudioDTO) {
        Estudio estudio = estudioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudio no encontrado con ID: " + id));
        estudio.setDescripcion(estudioDTO.getDescripcion());
        Estudio updatedEstudio = estudioRepository.save(estudio);
        return convertToDTO(updatedEstudio);
    }

    @Override
    public Optional<EstudioDTO> getEstudioById(Integer id) {
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

    private EstudioDTO convertToDTO(Estudio estudio) {
        EstudioDTO estudioDTO = new EstudioDTO();
        estudioDTO.setId(estudio.getId());
        estudioDTO.setDescripcion(estudio.getDescripcion());
        return estudioDTO;
    }

}
