package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.CostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearCostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarCostoHospitalizacionDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.CostoHospitalizacionService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.CostoHospitalizacionRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CostoHospitalizacionServiceImpl implements CostoHospitalizacionService {

    private final CostoHospitalizacionRepository costoHospitalizacionRepository;
    private final UserRepository userRepository;
    private final EstadoCuentaRepository estadoCuentaRepository;
    private final ModelMapper modelMapper;

    public CostoHospitalizacionServiceImpl(CostoHospitalizacionRepository costoHospitalizacionRepository, UserRepository userRepository, EstadoCuentaRepository estadoCuentaRepository, ModelMapper modelMapper) {
        this.costoHospitalizacionRepository = costoHospitalizacionRepository;
        this.userRepository = userRepository;
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.modelMapper = modelMapper;
    }
    
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCostoHospitalizacion(CrearCostoHospitalizacionDTO crearCostoHospitalizacionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CostoHospitalizacionEntity costoHospitalizacionEntity = new CostoHospitalizacionEntity();
        costoHospitalizacionEntity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearCostoHospitalizacionDTO.getPec_estadoCuentaId()).orElseThrow(
                () -> new ResourceNotFoundException("Estado de cuenta no encontrado")));
        costoHospitalizacionEntity.setFechaIngreso(crearCostoHospitalizacionDTO.getFechaIngreso());
        costoHospitalizacionEntity.setFechaAlta(crearCostoHospitalizacionDTO.getFechaAlta());
        costoHospitalizacionEntity.setTipoHabitacion(crearCostoHospitalizacionDTO.getTipoHabitacion());
        costoHospitalizacionEntity.setCostoPorDia(crearCostoHospitalizacionDTO.getCostoPorDia());
        costoHospitalizacionEntity.setCantidadDias(crearCostoHospitalizacionDTO.getCantidadDias());
        costoHospitalizacionEntity.setTotalCosto(crearCostoHospitalizacionDTO.getTotalCosto());
        costoHospitalizacionRepository.save(costoHospitalizacionEntity);
        return new ApiResponse(true, "Costo de hospitalizacion ingresado correctamente");
    }

    @Override
    public ListResponse<CostoHospitalizacionDTO> getAllCostoHospitalizacion(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CostoHospitalizacionEntity> costoHospitalizacionEntityPage = costoHospitalizacionRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CostoHospitalizacionDTO> data = costoHospitalizacionEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, costoHospitalizacionEntityPage.getTotalElements(), costoHospitalizacionEntityPage.getTotalPages(), costoHospitalizacionEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCostoHospitalizacion(UUID pec_costoHospitalizacionId, ActualizarCostoHospitalizacionDTO actualizarCostoHospitalizacionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CostoHospitalizacionEntity costoHospitalizacionEntity = costoHospitalizacionRepository.findById(pec_costoHospitalizacionId).orElseThrow(
                () -> new ResourceNotFoundException("Costo de hospitalizacion no encontrado"));
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getPec_estadoCuentaId()).flatMap(estadoCuentaRepository::findById).ifPresent(costoHospitalizacionEntity::setEstadoCuentaEntity);
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getFechaIngreso()).ifPresent(costoHospitalizacionEntity::setFechaIngreso);
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getFechaAlta()).ifPresent(costoHospitalizacionEntity::setFechaAlta);
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getTipoHabitacion()).ifPresent(costoHospitalizacionEntity::setTipoHabitacion);
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getCostoPorDia()).ifPresent(costoHospitalizacionEntity::setCostoPorDia);
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getCantidadDias()).ifPresent(costoHospitalizacionEntity::setCantidadDias);
        Optional.ofNullable(actualizarCostoHospitalizacionDTO.getTotalCosto()).ifPresent(costoHospitalizacionEntity::setTotalCosto);
        return new ApiResponse(true, "Costo de hospitalizacion modificado correctamente");
    }

    @Override
    public CostoHospitalizacionDTO getCostoHospitalizacionById(UUID pec_costoHospitalizacionId) {
        CostoHospitalizacionEntity costoHospitalizacionEntity = costoHospitalizacionRepository.findById(pec_costoHospitalizacionId).orElseThrow(
                () -> new ResourceNotFoundException("Costo de hospitalizacion no encontrado"));
        return convertToDTO(costoHospitalizacionEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCostoHospitalizacion(UUID pec_costoHospitalizacionId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        costoHospitalizacionRepository.deleteById(pec_costoHospitalizacionId);
        return new ApiResponse(true, "Costo de hospitalizacion eliminado correctamente");
    }

    private CostoHospitalizacionDTO convertToDTO(CostoHospitalizacionEntity costoHospitalizacionEntity) {
        return modelMapper.map(costoHospitalizacionEntity, CostoHospitalizacionDTO.class);
    }

}