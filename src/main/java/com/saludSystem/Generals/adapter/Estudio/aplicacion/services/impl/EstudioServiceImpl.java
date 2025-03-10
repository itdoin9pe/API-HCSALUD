package com.saludSystem.Generals.adapter.Estudio.aplicacion.services.impl;
/*
import com.saludSystem.dtos.Generals.Estudio.ActualizarEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.CrearEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.EstudioDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.Estudio;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Generals.EstudioRepository;
import com.saludSystem.services.modules.Generals.Estudios.EstudioService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EstudioServiceImpl implements EstudioService {

    private final EstudioRepository estudioRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public EstudioServiceImpl(EstudioRepository estudioRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.estudioRepository = estudioRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveEstudio(CrearEstudioDTO crearEstudioDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Estudio estudio = new Estudio();
        estudio.setDescripcion(crearEstudioDTO.getDescripcion());
        estudio.setUser(user);
        estudio.setHospital(hospital);
        estudioRepository.save(estudio);
        return new ApiResponse(true, "Estudio registrado correctamente.");
    }

    @Override
    public ApiResponse deleteEstudio(UUID estudioId) {
        estudioRepository.deleteById(estudioId);
        return new ApiResponse(true, "Estudio eliminado correctamente");
    }

    @Override
    public ListResponse<EstudioDTO> getAllEstudios(UUID hospitalId, int page, int rows) {
        List<Estudio> estudios = estudioRepository.findByHospital_HospitalId(hospitalId);
        List<EstudioDTO> data = estudios.stream().map(estudio -> {
            EstudioDTO dto = new EstudioDTO();
            dto.setEstudioId(estudio.getEstudioId());
            dto.setDescripcion(estudio.getDescripcion());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public ApiResponse updateEstudio(UUID estudioId, ActualizarEstudioDTO actualizarEstudioDTO) {
        Estudio estudio = estudioRepository.findById(estudioId)
                .orElseThrow(() -> new ResourceNotFoundException("Estudio no encontrado"));
        Optional.ofNullable(actualizarEstudioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(estudio::setDescripcion);
        estudioRepository.save(estudio);
        return new ApiResponse(true, "Estudio actualizado correctamente");
    }

    @Override
    public EstudioDTO getEstudioById(UUID estudioId) {
        Estudio estudio = estudioRepository.findById(estudioId)
                .orElseThrow( () -> new RuntimeException("Estudio no encontrado"));
        EstudioDTO dto = new EstudioDTO();
        dto.setEstudioId(estudio.getEstudioId());
        dto.setDescripcion(estudio.getDescripcion());
        return dto;
    }

    @Override
    public List<EstudioDTO> getEstudioList() {
        return estudioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EstudioDTO convertToDTO(Estudio estudio) {
        return modelMapper.map(estudio, EstudioDTO.class);
    }

}

 */