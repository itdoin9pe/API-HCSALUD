package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearTipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarTipoMaterialDTO;
import com.saludSystem.application.services.Operaciones.TipoMaterialService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Operaciones.PresentacionEntity;
import com.saludSystem.domain.model.Operaciones.TipoMaterialEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.TipoMaterialRepository;
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
public class TipoMaterialServiceImpl implements TipoMaterialService {

    private final TipoMaterialRepository tipoMaterialRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoMaterialServiceImpl(TipoMaterialRepository tipoMaterialRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoMaterialRepository = tipoMaterialRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoMaterial(CrearTipoMaterialDTO crearTipoMaterialDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoMaterialEntity tipoMaterialEntity = new TipoMaterialEntity();
        tipoMaterialEntity.setNombre(crearTipoMaterialDTO.getNombre());
        tipoMaterialEntity.setDescripcion(crearTipoMaterialDTO.getDescripcion());
        tipoMaterialEntity.setEstado(crearTipoMaterialDTO.getEstado());
        tipoMaterialEntity.setHospital(hospital);
        tipoMaterialEntity.setUser(userEntity);
        tipoMaterialRepository.save(tipoMaterialEntity);
        return new ApiResponse(true, "Tipo material creado correctamente");
    }

    @Override
    public List<TipoMaterialDTO> getTipoMaterialList() {
        return tipoMaterialRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TipoMaterialDTO getTipoMaterialById(UUID tipoMaterialId) {
        TipoMaterialEntity tipoMaterialEntity = tipoMaterialRepository.findById(tipoMaterialId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo material no encontrado"));
        return convertToDTO(tipoMaterialEntity);
    }

    @Override
    public ListResponse<TipoMaterialDTO> getAllTipoMaterial(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoMaterialEntity> tipoMaterialEntityPage = tipoMaterialRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoMaterialDTO> data = tipoMaterialEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoMaterialEntityPage.getTotalElements(), tipoMaterialEntityPage.getTotalPages(), tipoMaterialEntityPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateTipoMaterial(UUID tipoMaterialId, ActualizarTipoMaterialDTO actualizarTipoMaterialDTO) {
        TipoMaterialEntity tipoMaterialEntity = tipoMaterialRepository.findById(tipoMaterialId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo material no encontrado"));
        Optional.ofNullable(actualizarTipoMaterialDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoMaterialEntity::setNombre);
        Optional.ofNullable(actualizarTipoMaterialDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tipoMaterialEntity::setDescripcion);
        Optional.ofNullable(actualizarTipoMaterialDTO.getEstado()).ifPresent(tipoMaterialEntity::setEstado);
        tipoMaterialRepository.save(tipoMaterialEntity);
        return new ApiResponse(true, "Tipo material actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTipoMaterial(UUID tipoMaterialId) {
        tipoMaterialRepository.deleteById(tipoMaterialId);
        return new ApiResponse(true, "Tipo material eliminado correctamente");
    }

    private TipoMaterialDTO convertToDTO(TipoMaterialEntity tipoMaterialEntity) {
        return modelMapper.map(tipoMaterialEntity, TipoMaterialDTO.class);
    }

}