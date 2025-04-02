package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.services.Operaciones.MarcaService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;
import com.saludSystem.domain.model.Operaciones.MarcaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.MarcaRepository;
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
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public MarcaServiceImpl(MarcaRepository marcaRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.marcaRepository = marcaRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveMarca(CrearMarcaDTO crearMarcaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        MarcaEntity marcaEntity = new MarcaEntity();
        marcaEntity.setNombre(crearMarcaDTO.getNombre());
        marcaEntity.setEstado(crearMarcaDTO.getEstado());
        marcaEntity.setHospital(hospital);
        marcaEntity.setUser(user);
        marcaRepository.save(marcaEntity);
        return new ApiResponse(true, "Marca registrada correctamente");
    }

    @Override
    public List<MarcaDTO> getMarcaList() {
        return marcaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<MarcaDTO> getAllMarca(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MarcaEntity> marcaModelPage = marcaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MarcaDTO> data = marcaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, marcaModelPage.getTotalElements(), marcaModelPage.getTotalPages(), marcaModelPage.getNumber() + 1);
    }

    @Override
    public MarcaDTO getMarcaById(UUID marcaId) {
        MarcaEntity marcaEntity = marcaRepository.findById(marcaId).orElseThrow( () -> new ResourceNotFoundException("Marca no encontrada"));
        return convertToDTO(marcaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateMarca(UUID marcaId, ActualizarMarcaDTO actualizarMarcaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        MarcaEntity marcaEntity = marcaRepository.findById(marcaId).orElseThrow( () -> new ResourceNotFoundException("Marca no encontrada"));
        Optional.ofNullable(actualizarMarcaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(marcaEntity::setNombre);
        Optional.ofNullable(actualizarMarcaDTO.getEstado()).ifPresent(marcaEntity::setEstado);
        marcaRepository.save(marcaEntity);
        return new ApiResponse(true, "Marca actualizada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteMarca(UUID marcaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        marcaRepository.deleteById(marcaId);
        return new ApiResponse(true, "Marca eliminada correctamente");
    }

    private MarcaDTO convertToDTO(MarcaEntity marcaEntity) {
        return modelMapper.map(marcaEntity, MarcaDTO.class);
    }

}