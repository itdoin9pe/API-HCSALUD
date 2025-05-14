package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarAlmacenDTO;
import com.saludSystem.application.services.Movimiento.AlmacenService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SedeEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Movimientos.AlmacenEntity;
import com.saludSystem.domain.model.SucursalEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SedeRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.AlmacenRepository;
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
public class AlmacenServiceImpl implements AlmacenService {

    private final AlmacenRepository almacenRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final SucursalRepository sucursalRepository;
    private final SedeRepository sedeRepository;
    private final ModelMapper modelMapper;

    public AlmacenServiceImpl(AlmacenRepository almacenRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, SucursalRepository sucursalRepository, SedeRepository sedeRepository, ModelMapper modelMapper) {
        this.almacenRepository = almacenRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.sucursalRepository = sucursalRepository;
        this.sedeRepository = sedeRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveAlmacen(CrearAlmacenDTO crearAlmacenDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        SucursalEntity sucursal = sucursalRepository.findFirstByOrderBySucursalIdAsc()
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        AlmacenEntity almacenEntity = new AlmacenEntity();
        almacenEntity.setNombre(crearAlmacenDTO.getNombre());
        Optional<SedeEntity> sedeEntity = sedeRepository.findById(crearAlmacenDTO.getSedeId());
        sedeEntity.ifPresent(almacenEntity::setSedeEntity);
        almacenEntity.setEstado(crearAlmacenDTO.getEstado());
        almacenEntity.setHospital(hospital);
        almacenEntity.setUser(userEntity);
        almacenEntity.setSucursalEntity(sucursal);
        almacenRepository.save(almacenEntity);
        return new ApiResponse(true, "Almacen creado correctamente");
    }

    @Override
    public List<AlmacenDTO> getAlmacenList() {
        return almacenRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public AlmacenDTO getAlmacenById(UUID almacenId) {
        AlmacenEntity almacenEntity = almacenRepository.findById(almacenId).orElseThrow(
                () -> new ResourceNotFoundException("Almacen no encontrado"));
        return convertToDTO(almacenEntity);
    }

    @Override
    public ListResponse<AlmacenDTO> getAllAlmacen(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AlmacenEntity> almacenEntityPage = almacenRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AlmacenDTO> data = almacenEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, almacenEntityPage.getTotalElements(), almacenEntityPage.getTotalPages(), almacenEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateAlmacen(UUID almacenId, ActualizarAlmacenDTO actualizarAlmacenDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        AlmacenEntity almacenEntity = almacenRepository.findById(almacenId).orElseThrow(
                () -> new ResourceNotFoundException("Almacen no encontrado"));
        Optional.ofNullable(actualizarAlmacenDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(almacenEntity::setNombre);
        Optional.ofNullable(actualizarAlmacenDTO.getSedeId()).flatMap(sedeRepository::findById).ifPresent(almacenEntity::setSedeEntity);
        Optional.ofNullable(actualizarAlmacenDTO.getEstado()).ifPresent(almacenEntity::setEstado);
        almacenRepository.save(almacenEntity);
        return new ApiResponse(true, "Almacen eliminado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteAlmacen(UUID almacenId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        almacenRepository.deleteById(almacenId);
        return new ApiResponse(true, "Almacen eliminado correctamente");
    }

    private AlmacenDTO convertToDTO(AlmacenEntity almacenEntity) {
        return modelMapper.map(almacenEntity, AlmacenDTO.class);
    }

}