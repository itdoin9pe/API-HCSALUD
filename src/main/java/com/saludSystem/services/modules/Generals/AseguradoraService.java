package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.entities.Aseguradora;
import com.saludSystem.repositories.modules.Generals.AseguradoraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AseguradoraService {

    @Autowired
    private AseguradoraRepository aseguradoraRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Guardar aseguradora
    public AseguradoraDTO saveAseguradora(AseguradoraDTO aseguradoraDTO) {
        Aseguradora aseguradora = new Aseguradora();
        aseguradora.setDescripcion(aseguradoraDTO.getDescripcion());
        aseguradora.setEstado(aseguradoraDTO.getEstado());
        Aseguradora savedAseguradora = aseguradoraRepository.save(aseguradora);

        return convertToDTO(savedAseguradora);
    }

    public List<AseguradoraDTO> getAllAseguradoras(int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Aseguradora> aseguradorasPage = aseguradoraRepository.findAll(pageable);

        return aseguradorasPage.getContent().stream()
                .map(aseguradora -> modelMapper.map(aseguradora, AseguradoraDTO.class))
                .toList();
    }


    // Obtener la lista de aseguradoras simplificada
    public List<AseguradoraDTO> getAseguradoraList() {
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

        if (aseguradoraDTO.getDescripcion() != null) {
            aseguradora.setDescripcion(aseguradoraDTO.getDescripcion());
        }
        if (aseguradoraDTO.getEstado() != null) {
            aseguradora.setEstado(aseguradoraDTO.getEstado());
        }

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
        dto.setAseguradoraId(aseguradora.getId());
        dto.setDescripcion(aseguradora.getDescripcion());
        dto.setEstado(aseguradora.isEstado());
        return dto;
    }

    // Obtener el total de aseguradoras
    public long getTotalCount() {
        return aseguradoraRepository.count();
    }
}
