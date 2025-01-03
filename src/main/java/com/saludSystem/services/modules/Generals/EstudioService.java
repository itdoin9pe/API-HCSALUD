package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.EstudioDTO;
import com.saludSystem.entities.Estudio;
import com.saludSystem.repositories.modules.Generals.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public EstudioDTO saveEstudio(EstudioDTO estudioDTO) {
        Estudio estudio = new Estudio();
        estudio.setDescripcion(estudioDTO.getDescripcion());
        Estudio savedEstudio = estudioRepository.save(estudio);

        return convertToDTO(savedEstudio);
    }

    public List<EstudioDTO> getAllEstudios() {
        return estudioRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudioDTO> getEstudioById(int id) {
        return estudioRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteEstudio(int id) {
        estudioRepository.deleteById(id);
    }

    public EstudioDTO updateEstudio(int id, EstudioDTO estudioDTO) {
        Estudio estudio = estudioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudio not found: " + id));
        estudio.setDescripcion(estudioDTO.getDescripcion());

        Estudio updatedEstudio = estudioRepository.save(estudio);

        return convertToDTO(updatedEstudio);
    }

    // Conversión de entidad a DTO
    private EstudioDTO convertToDTO(Estudio estudio) {
        EstudioDTO estudioDTO = new EstudioDTO();
        estudioDTO.setId(estudio.getId());
        estudioDTO.setDescripcion(estudio.getDescripcion());
        return estudioDTO;
    }

}
