package com.saludSystem.application.services.Paciente.impl.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.PacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearPacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarPacienteAlergiaDTO;
import com.saludSystem.application.services.Paciente.HistorialClinico.PacienteAlergiaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.AlergiaEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.HistorialClinico.PacienteAlergiaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.AlergiaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico.PacienteAlergiaRepository;
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
public class PacienteAlergiaServiceImpl implements PacienteAlergiaService {

    private final PacienteAlergiaRepository pacienteAlergiaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final AlergiaRepository alergiaRepository;
    private final ModelMapper modelMapper;

    public PacienteAlergiaServiceImpl(PacienteAlergiaRepository pacienteAlergiaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, AlergiaRepository alergiaRepository, ModelMapper modelMapper) {
        this.pacienteAlergiaRepository = pacienteAlergiaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.alergiaRepository = alergiaRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse savePacienteAlergia(CrearPacienteAlergiaDTO crearPacienteAlergiaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        PacienteAlergiaEntity pacienteAlergiaEntity = new PacienteAlergiaEntity();
        Optional<AlergiaEntity> alergiaEntity = alergiaRepository.findById(crearPacienteAlergiaDTO.getAlergiaId());
        alergiaEntity.ifPresent(pacienteAlergiaEntity::setAlergiaEntity);
        pacienteAlergiaEntity.setObservacion(crearPacienteAlergiaDTO.getObservacion());
        pacienteAlergiaEntity.setEstado(crearPacienteAlergiaDTO.getEstado());
        pacienteAlergiaRepository.save(pacienteAlergiaEntity);
        return new ApiResponse(true, "Alergia de paciente guardado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updatePacienteAlergia(UUID pacienteAlergiaId, ActualizarPacienteAlergiaDTO actualizarPacienteAlergiaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        PacienteAlergiaEntity pacienteAlergiaEntity = pacienteAlergiaRepository.findById(pacienteAlergiaId).orElseThrow(
                () -> new ResourceNotFoundException("Antecedente no encontrad"));
        Optional.ofNullable(actualizarPacienteAlergiaDTO.getPacienteAlergiaId()).flatMap(alergiaRepository::findById).ifPresent(pacienteAlergiaEntity::setAlergiaEntity);
        Optional.ofNullable(actualizarPacienteAlergiaDTO.getObservacion()).filter(desc -> !desc.isBlank()).ifPresent(pacienteAlergiaEntity::setObservacion);
        Optional.ofNullable(actualizarPacienteAlergiaDTO.getEstado()).ifPresent(pacienteAlergiaEntity::setEstado);
        pacienteAlergiaRepository.save(pacienteAlergiaEntity);
        return new ApiResponse(true, "Alergia de paciente modificado correctamente");
    }

    @Override
    public PacienteAlergiaDTO getPacienteAlergiaById(UUID pacienteAlergiaId) {
        PacienteAlergiaEntity pacienteAlergiaEntity = pacienteAlergiaRepository.findById(pacienteAlergiaId).
                orElseThrow( () -> new ResourceNotFoundException("Alergia de paciente no encontrado"));
        return convertToDTO(pacienteAlergiaEntity);
    }

    @Override
    public ListResponse<PacienteAlergiaDTO> getAllPacienteAlergia(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PacienteAlergiaEntity> pacienteAlergiaEntityPage = pacienteAlergiaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PacienteAlergiaDTO> data = pacienteAlergiaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, pacienteAlergiaEntityPage.getTotalElements(), pacienteAlergiaEntityPage.getTotalPages(), pacienteAlergiaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deletePacienteAlergia(UUID pacienteAlergiaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        pacienteAlergiaRepository.deleteById(pacienteAlergiaId);
        return new ApiResponse(true, "Alergia de paciente eliminado correctamente");
    }

    private PacienteAlergiaDTO convertToDTO(PacienteAlergiaEntity pacienteAlergiaEntity) {
        return modelMapper.map(pacienteAlergiaEntity, PacienteAlergiaDTO.class);
    }

}