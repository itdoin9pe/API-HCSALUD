package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearApoderadoDTO;
import com.saludSystem.application.services.Catalogo.ApoderadoService;
import com.saludSystem.domain.model.Catalogo.ApoderadoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ApoderadoRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
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
public class ApoderadoServiceImpl implements ApoderadoService {

    private final ApoderadoRepository apoderadoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.apoderadoRepository = apoderadoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveApoderado(CrearApoderadoDTO crearApoderadoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ApoderadoEntity apoderadoEntity = new ApoderadoEntity();
        apoderadoEntity.setNombre(crearApoderadoDTO.getNombre());
        apoderadoEntity.setDireccion(crearApoderadoDTO.getDireccion());
        apoderadoEntity.setNroDocumento(crearApoderadoDTO.getTelefono());
        apoderadoEntity.setTelefono(crearApoderadoDTO.getTelefono());
        apoderadoEntity.setEstado(crearApoderadoDTO.getEstado());
        apoderadoEntity.setUser(userEntity);
        apoderadoEntity.setHospital(hospital);
        apoderadoRepository.save(apoderadoEntity);
        return new ApiResponse(true, "Apoderado registeado correctamente");
    }

    @Override
    public ApiResponse updateApoderado(UUID apoderadoId, ActualizarApoderadoDTO actualizarApoderadoDTO) {
        ApoderadoEntity apoderadoEntity = apoderadoRepository.findById(apoderadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Apoderado no encontrado"));
        Optional.ofNullable(actualizarApoderadoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoEntity::setNombre);
        Optional.ofNullable(actualizarApoderadoDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoEntity::setDireccion);
        Optional.ofNullable(actualizarApoderadoDTO.getTelefono()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoEntity::setTelefono);
        Optional.ofNullable(actualizarApoderadoDTO.getNroDocumento()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoEntity::setNroDocumento);
        Optional.ofNullable(actualizarApoderadoDTO.getEstado()).ifPresent(apoderadoEntity::setEstado);
        apoderadoRepository.save(apoderadoEntity);
        return new ApiResponse(true, "Apoderado actualizado correctamente");
    }

    @Override
    public ListResponse<ApoderadoDTO> getAllApoderado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ApoderadoEntity> apoderadoModelPage = apoderadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ApoderadoDTO> data = apoderadoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, apoderadoModelPage.getTotalElements(), apoderadoModelPage.getTotalPages(), apoderadoModelPage.getNumber() + 1);
    }

    @Override
    public ApoderadoDTO getApoderadoById(UUID apoderadoId) {
        ApoderadoEntity apoderadoEntity = apoderadoRepository.findById(apoderadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Apoderado no encontrado"));
        return convertToDTO(apoderadoEntity);
    }

    @Override
    public ApiResponse deleteApoderado(UUID apoderadoId) {
        apoderadoRepository.deleteById(apoderadoId);
        return new ApiResponse(true,  "Apoderado eliminado correctamente");
    }

    private ApoderadoDTO convertToDTO(ApoderadoEntity apoderadoEntity) {
        return modelMapper.map(apoderadoEntity, ApoderadoDTO.class);
    }
}