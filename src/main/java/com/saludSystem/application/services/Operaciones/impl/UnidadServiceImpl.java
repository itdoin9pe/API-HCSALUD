package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.services.Operaciones.UnidadService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.GET.UnidadDTO;
import com.saludSystem.domain.model.Operaciones.UnidadEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.UnidadRepository;
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
public class UnidadServiceImpl implements UnidadService {

    private final UnidadRepository unidadRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UnidadServiceImpl(UnidadRepository unidadRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.unidadRepository = unidadRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveUnidad(CrearUnidadDTO crearUnidadDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        UnidadEntity unidadEntity = new UnidadEntity();
        unidadEntity.setNombre(crearUnidadDTO.getNombre());
        unidadEntity.setSiglas(crearUnidadDTO.getSiglas());
        unidadEntity.setDescripcion(crearUnidadDTO.getDescripcion());
        unidadEntity.setEstado(crearUnidadDTO.getEstado());
        unidadEntity.setUser(user);
        unidadEntity.setHospital(hospital);
        unidadRepository.save(unidadEntity);
        return new ApiResponse(true, "Unidad creada correctamente");
    }

    @Override
    public List<UnidadDTO> getUnidadList() {
        return unidadRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UnidadDTO getUnidadById(UUID unidadId) {
        UnidadEntity unidadEntity = unidadRepository.findById(unidadId).orElseThrow( () -> new ResourceNotFoundException("Unidad no encontrada"));
        return convertToDTO(unidadEntity);
    }

    @Override
    public ListResponse<UnidadDTO> getAllUnidad(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<UnidadEntity> unidadModelPage = unidadRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<UnidadDTO> data = unidadModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, unidadModelPage.getTotalElements(), unidadModelPage.getTotalPages(), unidadModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse updateUnidad(UUID unidadId, ActualizarUnidadDTO actualizarUnidadDTO) {
        UnidadEntity unidadEntity = unidadRepository.findById(unidadId).orElseThrow( () -> new ResourceNotFoundException("Unidad no encontrada"));
        Optional.ofNullable(actualizarUnidadDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(unidadEntity::setNombre);
        Optional.ofNullable(actualizarUnidadDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(unidadEntity::setDescripcion);
        Optional.ofNullable(actualizarUnidadDTO.getSiglas()).filter(desc -> !desc.isBlank()).ifPresent(unidadEntity::setSiglas);
        Optional.ofNullable(actualizarUnidadDTO.getEstado()).ifPresent(unidadEntity::setEstado);
        unidadRepository.save(unidadEntity);
        return new ApiResponse(true, "Unidad actualizada correctamente");
    }

    @Override
    public ApiResponse deleteUnidad(UUID unidadId) {
        unidadRepository.deleteById(unidadId);
        return new ApiResponse(true, "Unidad eliminado correctamente");
    }

    private UnidadDTO convertToDTO(UnidadEntity unidadEntity) {
        return modelMapper.map(unidadEntity, UnidadDTO.class);
    }

}