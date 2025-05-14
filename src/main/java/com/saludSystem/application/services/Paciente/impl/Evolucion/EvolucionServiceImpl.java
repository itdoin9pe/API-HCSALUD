package com.saludSystem.application.services.Paciente.impl.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.EvolucionDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearEvolucionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarEvolucionDTO;
import com.saludSystem.application.services.Paciente.Evolucion.EvolucionService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.Evolucion.EvolucionEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.EvolucionRepository;
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
public class EvolucionServiceImpl implements EvolucionService {

    private final EvolucionRepository evolucionRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public EvolucionServiceImpl(EvolucionRepository evolucionRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.evolucionRepository = evolucionRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEvolucion(CrearEvolucionDTO crearEvolucionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        EvolucionEntity evolucionEntity = new EvolucionEntity();
        evolucionRepository.save(evolucionEntity);
        evolucionEntity.setPacienteEntity(pacienteRepository.findById(crearEvolucionDTO.getPacienteId()).
                orElseThrow(() -> new ResourceNotFoundException("Paciente not found")));
        evolucionEntity.setFechaInicio(crearEvolucionDTO.getFechaInicio());
        evolucionEntity.setFinalizada(crearEvolucionDTO.getFinalizada());
        evolucionEntity.setHospital(hospital);
        evolucionEntity.setUser(userEntity);
        evolucionRepository.save(evolucionEntity);
        return new ApiResponse(true, "Evolucion creada correctamente");
    }

    @Override
    public ListResponse<EvolucionDTO> getAllEvolucion(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EvolucionEntity> evolucionEntityPage = evolucionRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EvolucionDTO> data = evolucionEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, evolucionEntityPage.getTotalElements(), evolucionEntityPage.getTotalPages(), evolucionEntityPage.getNumber() + 1);
    }

    @Override
    public EvolucionDTO getEvolucionById(UUID pacienteEvolucionId) {
        EvolucionEntity evolucionEntity = evolucionRepository.findById(pacienteEvolucionId).orElseThrow(
                () -> new ResourceNotFoundException("Evolucion no encontrada"));
        return convertToDTO(evolucionEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEvolucion(UUID pacienteEvolucionId, ActualizarEvolucionDTO actualizarEvolucionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        EvolucionEntity evolucionEntity = evolucionRepository.findById(pacienteEvolucionId).orElseThrow(
                () -> new ResourceNotFoundException("Evolucion no encontrada"));
        Optional.ofNullable(actualizarEvolucionDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(evolucionEntity::setPacienteEntity);
        Optional.ofNullable(actualizarEvolucionDTO.getFechaInicio()).ifPresent(evolucionEntity::setFechaInicio);
        Optional.ofNullable(actualizarEvolucionDTO.getFinalizada()).ifPresent(evolucionEntity::setFinalizada);
        evolucionRepository.save(evolucionEntity);
        return new ApiResponse(true, "Evolucion actualizada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteEvolucion(UUID pacienteEvolucionId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        evolucionRepository.deleteById(pacienteEvolucionId);
        return new ApiResponse(true, "Evolucion eliminada correctamente");
    }

    private EvolucionDTO convertToDTO(EvolucionEntity evolucionEntity) {
        return modelMapper.map(evolucionEntity, EvolucionDTO.class);
    }

}