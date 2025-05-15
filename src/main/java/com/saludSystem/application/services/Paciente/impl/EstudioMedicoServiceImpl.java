package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.EstudioMedicoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearEstudioMedicoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarEstudioMedicoDTO;
import com.saludSystem.application.services.Paciente.EstudioMedicoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.EstudioMedicoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.EstudioMedicoRepository;
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
public class EstudioMedicoServiceImpl implements EstudioMedicoService {

    private final EstudioMedicoRepository estudioMedicoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public EstudioMedicoServiceImpl(EstudioMedicoRepository estudioMedicoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.estudioMedicoRepository = estudioMedicoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEstudioMedico(CrearEstudioMedicoDTO crearEstudioMedicoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        EstudioMedicoEntity estudioMedicoEntity = new EstudioMedicoEntity();
        estudioMedicoEntity.setDoctorEntity(doctorRepository.findById(crearEstudioMedicoDTO.getDoctorId()).orElseThrow(
                () -> new ResourceNotFoundException("Doctor no encontrado") ));
        estudioMedicoEntity.setPacienteEntity(pacienteRepository.findById(crearEstudioMedicoDTO.getPacienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Paciente no encontrado")));
        estudioMedicoEntity.setTipo(crearEstudioMedicoDTO.getTipo());
        estudioMedicoEntity.setRequestAt(crearEstudioMedicoDTO.getRequestAt());
        estudioMedicoEntity.setPerformedAt(crearEstudioMedicoDTO.getPerformedAt());
        estudioMedicoEntity.setDescripcion(crearEstudioMedicoDTO.getDescripcion());
        estudioMedicoEntity.setEstado(crearEstudioMedicoDTO.getEstado());
        estudioMedicoEntity.setHospital(hospital);
        estudioMedicoEntity.setUser(userEntity);
        estudioMedicoRepository.save(estudioMedicoEntity);
        return new ApiResponse(true, "Estudio medico creado correctamente");
    }

    @Override
    public ListResponse<EstudioMedicoDTO> getAllEstudioMedico(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstudioMedicoEntity> estudioMedicoEntityPage = estudioMedicoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstudioMedicoDTO> data = estudioMedicoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, estudioMedicoEntityPage.getTotalElements(), estudioMedicoEntityPage.getTotalPages(), estudioMedicoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        EstudioMedicoEntity estudioMedicoEntity = estudioMedicoRepository.findById(pacienteEstudioMedicoId).orElseThrow(
                () -> new ResourceNotFoundException("Estudio medico no encontrado"));
        Optional.ofNullable(actualizarEstudioMedicoDTO.getDoctorId()).flatMap(doctorRepository::findById).ifPresent(estudioMedicoEntity::setDoctorEntity);
        Optional.ofNullable(actualizarEstudioMedicoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(estudioMedicoEntity::setPacienteEntity);
        Optional.ofNullable(actualizarEstudioMedicoDTO.getTipo()).filter(desc -> !desc.isBlank()).ifPresent(estudioMedicoEntity::setTipo);
        Optional.ofNullable(actualizarEstudioMedicoDTO.getRequestAt()).ifPresent(estudioMedicoEntity::setRequestAt);
        Optional.ofNullable(actualizarEstudioMedicoDTO.getPerformedAt()).ifPresent(estudioMedicoEntity::setPerformedAt);
        Optional.ofNullable(actualizarEstudioMedicoDTO.getEstado()).filter(desc -> !desc.isBlank()).ifPresent(estudioMedicoEntity::setEstado);
        Optional.ofNullable(actualizarEstudioMedicoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(estudioMedicoEntity::setDescripcion);
        estudioMedicoRepository.save(estudioMedicoEntity);
        return new ApiResponse(true, "Estudio medico actualizado correctamente");
    }

    @Override
    public EstudioMedicoDTO getEstudioMedicoById(Long pacienteEstudioMedicoId) {
        EstudioMedicoEntity estudioMedicoEntity = estudioMedicoRepository.findById(pacienteEstudioMedicoId).orElseThrow(
                () -> new ResourceNotFoundException("Estudio medico no encontrado"));
        return convertToDTO(estudioMedicoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteEstudioMedico(Long pacienteEstudioMedicoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        estudioMedicoRepository.deleteById(pacienteEstudioMedicoId);
        return new ApiResponse(true, "Estudio nedico eliminado correctamente");
    }

    private EstudioMedicoDTO convertToDTO(EstudioMedicoEntity estudioMedicoEntity) {
        return modelMapper.map(estudioMedicoEntity, EstudioMedicoDTO.class);
    }

}