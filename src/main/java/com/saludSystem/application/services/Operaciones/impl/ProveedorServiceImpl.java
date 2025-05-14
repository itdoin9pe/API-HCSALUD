package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.dtos.Operaciones.GET.ProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProveedorDTO;
import com.saludSystem.application.services.Operaciones.ProveedorService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Operaciones.ProveedorEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProveedorRepository;
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
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.proveedorRepository = proveedorRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveProveedor(CrearProveedorDTO crearProveedorDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ProveedorEntity proveedorEntity = new ProveedorEntity();
        proveedorEntity.setRuc(crearProveedorDTO.getRuc());
        proveedorEntity.setNombre(crearProveedorDTO.getNombre());
        proveedorEntity.setDireccion(crearProveedorDTO.getDireccion());
        proveedorEntity.setTelefono(crearProveedorDTO.getTelefono());
        proveedorEntity.setCorreo(crearProveedorDTO.getCorreo());
        proveedorEntity.setContacto(crearProveedorDTO.getContacto());
        proveedorEntity.setHospital(hospital);
        proveedorEntity.setUser(userEntity);
        proveedorRepository.save(proveedorEntity);
        return new ApiResponse(true, "Proveedor agregado correctamente");
    }

    @Override
    public List<ProveedorDTO> getProveedorList() {
        return proveedorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProveedorDTO getProveedorById(UUID proveedorId) {
        ProveedorEntity proveedorEntity = proveedorRepository.findById(proveedorId).orElseThrow(
                () -> new ResourceNotFoundException("Proveedor no encontrado"));
        return convertToDTO(proveedorEntity);
    }

    @Override
    public ListResponse<ProveedorDTO> getAllProveedor(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ProveedorEntity> proveedorEntityPage = proveedorRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ProveedorDTO> data = proveedorEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, proveedorEntityPage.getTotalElements(), proveedorEntityPage.getTotalPages(), proveedorEntityPage.getNumber() +1 );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateProveedor(UUID proveedorId, ActualizarProveedorDTO actualizarProveedorDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        ProveedorEntity proveedorEntity = proveedorRepository.findById(proveedorId).orElseThrow(
                () -> new ResourceNotFoundException("Proveedor no encontrado"));
        Optional.ofNullable(actualizarProveedorDTO.getRuc()).filter(desc -> !desc.isBlank()).ifPresent(proveedorEntity::setRuc);
        Optional.ofNullable(actualizarProveedorDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(proveedorEntity::setNombre);
        Optional.ofNullable(actualizarProveedorDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(proveedorEntity::setDireccion);
        Optional.ofNullable(actualizarProveedorDTO.getTelefono()).filter(desc -> !desc.isBlank()).ifPresent(proveedorEntity::setTelefono);
        Optional.ofNullable(actualizarProveedorDTO.getCorreo()).filter(desc -> !desc.isBlank()).ifPresent(proveedorEntity::setCorreo);
        Optional.ofNullable(actualizarProveedorDTO.getContacto()).filter(desc -> !desc.isBlank()).ifPresent(proveedorEntity::setContacto);
        proveedorRepository.save(proveedorEntity);
        return new ApiResponse(true, "Proveedor actualizado correctamente");
    }

    @Override
    public ApiResponse deleteProveedor(UUID proveedorId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        proveedorRepository.deleteById(proveedorId);
        return new ApiResponse(true, "Proveedor eliminado correctamente");
    }

    private ProveedorDTO convertToDTO(ProveedorEntity proveedorEntity) {
        return modelMapper.map(proveedorEntity, ProveedorDTO.class);
    }

}