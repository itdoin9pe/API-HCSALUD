package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.services.Principal.EstudioService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarEstudioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEstudioDTO;
import com.saludSystem.application.dtos.Principal.GET.EstudioDTO;
import com.saludSystem.domain.model.Principal.EstudioEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.EstudioRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        EstudioEntity estudio = new EstudioEntity();
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
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstudioEntity> estudioModelPage = estudioRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstudioDTO> data = estudioModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, estudioModelPage.getTotalElements(), estudioModelPage.getTotalPages(), estudioModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse updateEstudio(UUID estudioId, ActualizarEstudioDTO actualizarEstudioDTO) {
        EstudioEntity estudio = estudioRepository.findById(estudioId)
                .orElseThrow(() -> new ResourceNotFoundException("Estudio no encontrado"));
        Optional.ofNullable(actualizarEstudioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(estudio::setDescripcion);
        estudioRepository.save(estudio);
        return new ApiResponse(true, "Estudio actualizado correctamente");
    }

    @Override
    public EstudioDTO getEstudioById(UUID estudioId) {
        EstudioEntity estudio = estudioRepository.findById(estudioId)
                .orElseThrow( () -> new RuntimeException("Estudio no encontrado"));
        return convertToDTO(estudio);
    }

    @Override
    public List<EstudioDTO> getEstudioList() {
        return estudioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EstudioDTO convertToDTO(EstudioEntity estudio) {
        return modelMapper.map(estudio, EstudioDTO.class);
    }

}