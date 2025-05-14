package com.saludSystem.application.services.Paciente.impl.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.AltaMedicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearAltaMedicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarAltaMedicaDTO;
import com.saludSystem.application.services.Paciente.Evolucion.AltaMedicaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.Evolucion.AltaMedicaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.AltaMedicaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.EvolucionRepository;
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
public class AltaMedicaServiceImpl implements AltaMedicaService {

    private final AltaMedicaRepository altaMedicaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final EvolucionRepository evolucionRepository;
    private final ModelMapper modelMapper;

    public AltaMedicaServiceImpl(AltaMedicaRepository altaMedicaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, EvolucionRepository evolucionRepository, ModelMapper modelMapper) {
        this.altaMedicaRepository = altaMedicaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.evolucionRepository = evolucionRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveAltaMedica(CrearAltaMedicaDTO crearAltaMedicaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        AltaMedicaEntity altaMedicaEntity = new AltaMedicaEntity();
        altaMedicaEntity.setEvolucionEntity(evolucionRepository.findById(crearAltaMedicaDTO.getPacienteEvolucionId())
                .orElseThrow( () -> new RuntimeException("Alta medica no encontrada")));
        altaMedicaEntity.setFecha(crearAltaMedicaDTO.getFecha());
        altaMedicaEntity.setResumenFinal(crearAltaMedicaDTO.getResumenFinal());
        altaMedicaEntity.setHospital(hospital);
        altaMedicaEntity.setUser(userEntity);
        altaMedicaRepository.save(altaMedicaEntity);
        return new ApiResponse(true, "Alta medica ingresada correctamente");
    }

    @Override
    public AltaMedicaDTO getAltaMedicaById(Long evolucionAltaMedicaId) {
        AltaMedicaEntity altaMedicaEntity = altaMedicaRepository.findById(evolucionAltaMedicaId).orElseThrow(
                () -> new ResourceNotFoundException("Alta medica no encontrada"));
        return convertToDTO(altaMedicaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateAltaMedica(Long evolucionAltaMedicaId, ActualizarAltaMedicaDTO actualizarAltaMedicaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        AltaMedicaEntity altaMedicaEntity = altaMedicaRepository.findById(evolucionAltaMedicaId).orElseThrow(
                () -> new ResourceNotFoundException("Alta medica no encontrada"));
        Optional.ofNullable(actualizarAltaMedicaDTO.getPacienteEvolucionId()).flatMap(evolucionRepository::findById).ifPresent(altaMedicaEntity::setEvolucionEntity);
        Optional.ofNullable(actualizarAltaMedicaDTO.getFecha()).ifPresent(altaMedicaEntity::setFecha);
        Optional.ofNullable(actualizarAltaMedicaDTO.getResumenFinal()).ifPresent(altaMedicaEntity::setResumenFinal);
        altaMedicaRepository.save(altaMedicaEntity);
        return new ApiResponse(true, "Alta medica modificada correctamente");
    }

    @Override
    public ListResponse<AltaMedicaDTO> getAllAltaMedica(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AltaMedicaEntity> altaMedicaEntityPage = altaMedicaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AltaMedicaDTO> data = altaMedicaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, altaMedicaEntityPage.getTotalElements(), altaMedicaEntityPage.getTotalPages(), altaMedicaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteAltaMedica(Long evolucionAltaMedicaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        altaMedicaRepository.deleteById(evolucionAltaMedicaId);
        return new ApiResponse(true, "Alta medica eliminada correctamente");
    }

    private AltaMedicaDTO convertToDTO(AltaMedicaEntity altaMedicaEntity) {
        return modelMapper.map(altaMedicaEntity, AltaMedicaDTO.class);
    }

}