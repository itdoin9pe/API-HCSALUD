package com.saludSystem.application.services.Paciente.impl.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.EstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearEstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarEstadoCuentaDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.EstadoCuentaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.EstadoCuenta.EstadoCuentaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
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
public class EstadoCuentaServiceImpl implements EstadoCuentaService {

    private final EstadoCuentaRepository estadoCuentaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public EstadoCuentaServiceImpl(EstadoCuentaRepository estadoCuentaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.estadoCuentaRepository = estadoCuentaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEstadoCuenta(CrearEstadoCuentaDTO crearEstadoCuentaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        EstadoCuentaEntity estadoCuentaEntity = new EstadoCuentaEntity();
        estadoCuentaEntity.setPacienteEntity(pacienteRepository.findById(crearEstadoCuentaDTO.getPacienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Paciente no encontrada")));
        estadoCuentaEntity.setFechaApertura(crearEstadoCuentaDTO.getFechaApertura());
        estadoCuentaEntity.setEstado(crearEstadoCuentaDTO.getEstado());
        estadoCuentaEntity.setTotalHospitalizacion(crearEstadoCuentaDTO.getTotalHospitalizacion());
        estadoCuentaEntity.setTotalMedicamentosEstudios(crearEstadoCuentaDTO.getTotalMedicamentosEstudios());
        estadoCuentaEntity.setTotalPagado(crearEstadoCuentaDTO.getTotalPagado());
        estadoCuentaEntity.setSaldoPendiente(crearEstadoCuentaDTO.getSaldoPendiente());
        estadoCuentaRepository.save(estadoCuentaEntity);
        return new ApiResponse(true, "Estado de cuenta creado correctamente");
    }

    @Override
    public ListResponse<EstadoCuentaDTO> getAllEstadoCuenta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstadoCuentaEntity> estadoCuentaEntityPage = estadoCuentaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstadoCuentaDTO> data = estadoCuentaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, estadoCuentaEntityPage.getTotalElements(), estadoCuentaEntityPage.getTotalPages(), estadoCuentaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEstadoCuenta(UUID pacienteEstadoCuentaId, ActualizarEstadoCuentaDTO actualizarEstadoCuentaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        EstadoCuentaEntity estadoCuentaEntity = estadoCuentaRepository.findById(pacienteEstadoCuentaId).orElseThrow(
                () -> new ResourceNotFoundException("Estado de cuenta no encontrada"));
        Optional.ofNullable(actualizarEstadoCuentaDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(estadoCuentaEntity::setPacienteEntity);
        Optional.ofNullable(actualizarEstadoCuentaDTO.getFechaApertura()).ifPresent(estadoCuentaEntity::setFechaApertura);
        Optional.ofNullable(actualizarEstadoCuentaDTO.getEstado()).ifPresent(estadoCuentaEntity::setEstado);
        Optional.ofNullable(actualizarEstadoCuentaDTO.getTotalHospitalizacion()).ifPresent(estadoCuentaEntity::setTotalHospitalizacion);
        Optional.ofNullable(actualizarEstadoCuentaDTO.getTotalMedicamentosEstudios()).ifPresent(estadoCuentaEntity::setTotalMedicamentosEstudios);
        Optional.ofNullable(actualizarEstadoCuentaDTO.getTotalPagado()).ifPresent(estadoCuentaEntity::setTotalPagado);
        Optional.ofNullable(actualizarEstadoCuentaDTO.getSaldoPendiente()).ifPresent(estadoCuentaEntity::setSaldoPendiente);
        return new ApiResponse(true, "Estado de cuenta modificado correctamente");
    }

    @Override
    public EstadoCuentaDTO getEstadoCuentaById(UUID pacienteEstadoCuentaId) {
        EstadoCuentaEntity estadoCuentaEntity = estadoCuentaRepository.findById(pacienteEstadoCuentaId).orElseThrow(
                () -> new ResourceNotFoundException("Estado de cuenta no encontrada"));
        return convertToDTO(estadoCuentaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteEstadoCuenta(UUID pacienteEstadoCuentaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        estadoCuentaRepository.deleteById(pacienteEstadoCuentaId);
        return new ApiResponse(true, "Estado de cuenta elimiinado correctamente");
    }

    private EstadoCuentaDTO convertToDTO(EstadoCuentaEntity estadoCuentaEntity) {
        return modelMapper.map(estadoCuentaEntity, EstadoCuentaDTO.class);
    }

}