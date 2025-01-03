package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.entities.Aseguradora;
import com.saludSystem.repositories.modules.Generals.AseguradoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AseguradoraService {

    @Autowired
    private AseguradoraRepository aseguradoraRepository;

    // Guardar aseguradora
    public AseguradoraDTO saveAseguradora(AseguradoraDTO aseguradoraDTO) {
        Aseguradora aseguradora = new Aseguradora();
        aseguradora.setDescripcion(aseguradoraDTO.getDescripcion());
        aseguradora.setEstado(aseguradoraDTO.isEstado());
        Aseguradora savedAseguradora = aseguradoraRepository.save(aseguradora);

        return convertToDTO(savedAseguradora);
    }

    // Obtener todas las aseguradoras
    public List<AseguradoraDTO> getAllAseguradoras() {
        return aseguradoraRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Obtener aseguradora por ID
    public Optional<AseguradoraDTO> getAseguradoraById(int id) {
        return aseguradoraRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Actualizar aseguradora
    public AseguradoraDTO updateAseguradora(int id, AseguradoraDTO aseguradoraDTO) {
        Aseguradora aseguradora = aseguradoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada con ID: " + id));
        aseguradora.setDescripcion(aseguradoraDTO.getDescripcion());
        aseguradora.setEstado(aseguradoraDTO.isEstado());

        Aseguradora updatedAseguradora = aseguradoraRepository.save(aseguradora);

        return convertToDTO(updatedAseguradora);
    }

    // Eliminar aseguradora
    public void deleteAseguradora(int id) {
        Aseguradora aseguradora = aseguradoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada con ID: " + id));
        aseguradoraRepository.delete(aseguradora);
    }

    // Conversión de entidad a DTO
    private AseguradoraDTO convertToDTO(Aseguradora aseguradora) {
        AseguradoraDTO dto = new AseguradoraDTO();
        dto.setDescripcion(aseguradora.getDescripcion());
        dto.setEstado(aseguradora.isEstado());
        return dto;
    }
}
