package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.services.Operaciones.PresentacionService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
import com.saludSystem.domain.model.Operaciones.PresentacionEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.PresentacionReposirory;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PresentacionServiceImpl implements PresentacionService {

    private final PresentacionReposirory presentacionReposirory;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public PresentacionServiceImpl(PresentacionReposirory presentacionReposirory, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.presentacionReposirory = presentacionReposirory;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse savePresentacion(CrearPresentacionDTO crearPresentacionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        PresentacionEntity presentacionEntity = new PresentacionEntity();
        presentacionEntity.setNombre(crearPresentacionDTO.getNombre());
        presentacionEntity.setEstado(crearPresentacionDTO.getEstado());
        presentacionEntity.setHospital(hospital);
        presentacionEntity.setUser(userEntity);
        presentacionReposirory.save(presentacionEntity);
        return new ApiResponse(true, "Presentacion registrada correctamente");
    }

    @Override
    public PresentacionDTO getPresentacionById(UUID presentacionId) {
        PresentacionEntity presentacionEntity = presentacionReposirory.findById(presentacionId).orElseThrow( () -> new ResourceNotFoundException("Presentacion not found"));
        return convertToDTO(presentacionEntity);
    }

    @Override
    public ListResponse<PresentacionDTO> getAllPresentacion(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PresentacionEntity> presentacionModelPage = presentacionReposirory.findByHospital_HospitalId(hospitalId, pageable);
        List<PresentacionDTO> data = presentacionModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, presentacionModelPage.getTotalElements(), presentacionModelPage.getTotalPages(), presentacionModelPage.getNumber() +1 );
    }

    @Override
    public List<PresentacionDTO> getPresentacionList() {
        return presentacionReposirory.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updatePresentacion(UUID presentacionId, ActualizarPresentacionDTO actualizarPresentacionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        PresentacionEntity presentacionEntity = presentacionReposirory.findById(presentacionId)
                .orElseThrow( () -> new ResourceNotFoundException("Presentacion not found"));
        Optional.ofNullable(actualizarPresentacionDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(presentacionEntity::setNombre);
        Optional.ofNullable(actualizarPresentacionDTO.getEstado()).ifPresent(presentacionEntity::setEstado);
        presentacionReposirory.save(presentacionEntity);
        return new ApiResponse(true, "Presentacion updated successfully");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deletePresentacion(UUID presentacionId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        presentacionReposirory.deleteById(presentacionId);
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        return new ApiResponse(true, "Presentacion eliminada correctamente");
    }

    private PresentacionDTO convertToDTO(PresentacionEntity presentacionEntity) {
        return modelMapper.map(presentacionEntity, PresentacionDTO.class);
    }

}