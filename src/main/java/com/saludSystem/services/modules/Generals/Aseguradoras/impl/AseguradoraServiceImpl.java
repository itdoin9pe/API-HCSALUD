package com.saludSystem.services.modules.Generals.Aseguradoras.impl;

import com.saludSystem.dtos.Generals.Aseguradora.ActualizarAseguradoraDTO;
import com.saludSystem.dtos.Generals.Aseguradora.AseguradoraDTO;
import com.saludSystem.dtos.Generals.Aseguradora.CrearAseguradoraDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.Aseguradora;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Generals.AseguradoraRepository;
import com.saludSystem.services.modules.Generals.Aseguradoras.AseguradoraService;
import org.modelmapper.ModelMapper;
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
    public ApiResponse saveAseguradora(CrearAseguradoraDTO crearAseguradoraDTO) {
        Aseguradora aseguradora = modelMapper.map(crearAseguradoraDTO, Aseguradora.class);
        aseguradoraRepository.save(aseguradora);
        return new ApiResponse(true, "Aseguradora creada Correctamente");
    }

    @Override
    public List<AseguradoraDTO> getAseguradoraList() {
        return aseguradoraRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AseguradoraDTO getAseguradoraById(UUID aseguradoraId) {
        Aseguradora aseguradora = aseguradoraRepository.findById(aseguradoraId)
                .orElseThrow(() -> new RuntimeException("Aseguradora no encontrada"));
        AseguradoraDTO dto = new AseguradoraDTO();
        dto.setAseguradoraId(aseguradora.getAseguradoraId());
        dto.setDescripcion(aseguradora.getDescripcion());
        dto.setEstado(aseguradora.getEstado());
        return dto;
    }


    @Override
    public ApiResponse updateAseguradora(UUID aseguradoraId, ActualizarAseguradoraDTO actualizarAseguradoraDTO) {
        Aseguradora aseguradora = aseguradoraRepository.findById(aseguradoraId).orElseThrow(
                () -> new ResourceNotFoundException("Aseguradora no encontrada con ID: " + aseguradoraId));
        Optional.ofNullable(actualizarAseguradoraDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(aseguradora::setDescripcion);
        Optional.ofNullable(actualizarAseguradoraDTO.getEstado()).ifPresent(aseguradora::setEstado);
        aseguradoraRepository.save(aseguradora);
        return new ApiResponse(true, "Aseguradora actualizada correctamente");
    }

    @Override
    public ApiResponse deleteAseguradora(UUID aseguradoraId) {
        aseguradoraRepository.deleteById(aseguradoraId);
        return new ApiResponse(true, "Aseguradora eliminada correctamente");
    }

    @Override
    public ListResponse<AseguradoraDTO> getAllAseguradoras(UUID hospitalId, int page, int rows) {
        List<Aseguradora> aseguradoras = aseguradoraRepository.findByHospital_HospitalId(hospitalId);
        List<AseguradoraDTO> data = aseguradoras.stream().map(aseguradora -> {
            AseguradoraDTO dto = new AseguradoraDTO();
            dto.setAseguradoraId(aseguradora.getAseguradoraId());
            dto.setDescripcion(aseguradora.getDescripcion());
            dto.setEstado(aseguradora.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data,data.size());
    }

    private AseguradoraDTO convertToDTO(Aseguradora aseguradora) {
        return modelMapper.map(aseguradora, AseguradoraDTO.class);
    }

}