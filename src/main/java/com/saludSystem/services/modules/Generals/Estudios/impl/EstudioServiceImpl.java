package com.saludSystem.services.modules.Generals.Estudios.impl;

import com.saludSystem.dtos.Generals.EstudioDTO;
import com.saludSystem.entities.Estudio;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.EstudioRepository;
import com.saludSystem.services.modules.Generals.Estudios.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudioServiceImpl implements EstudioService {

    private final EstudioRepository estudioRepository;

    @Autowired
    public EstudioServiceImpl(EstudioRepository estudioRepository) {
        this.estudioRepository = estudioRepository;
    }

    @Override
    public EstudioDTO saveEstudio(EstudioDTO estudioDTO) {
        Estudio estudio = new Estudio();
        estudio.setDescripcion(estudioDTO.getDescripcion());
        Estudio savedEstudio = estudioRepository.save(estudio);
        return convertToDTO(savedEstudio);
    }

    @Override
    public List<EstudioDTO> getAllEstudios() {
        return estudioRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EstudioDTO> getEstudioById(int id) {
        return estudioRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public void deleteEstudio(int id) {
        estudioRepository.deleteById(id);
    }

    @Override
    public EstudioDTO updateEstudio(int id, EstudioDTO estudioDTO) {
        Estudio estudio = estudioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudio no encontrado con ID: " + id));
        estudio.setDescripcion(estudioDTO.getDescripcion());
        Estudio updatedEstudio = estudioRepository.save(estudio);
        return convertToDTO(updatedEstudio);
    }

    private EstudioDTO convertToDTO(Estudio estudio) {
        EstudioDTO estudioDTO = new EstudioDTO();
        estudioDTO.setId(estudio.getId());
        estudioDTO.setDescripcion(estudio.getDescripcion());
        return estudioDTO;
    }

}
