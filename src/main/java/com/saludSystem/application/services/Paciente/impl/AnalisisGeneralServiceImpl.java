package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisGeneralDTO;
import com.saludSystem.application.services.Paciente.AnalisisGeneralService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.EspecialidadEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.AnalisisGeneralEntity;
import com.saludSystem.domain.model.Medico.DoctorEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.EspecialidadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.AnalisisGeneralRepository;
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
public class AnalisisGeneralServiceImpl implements AnalisisGeneralService {

    private final AnalisisGeneralRepository analisisGeneralRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final ModelMapper modelMapper;

    public AnalisisGeneralServiceImpl(AnalisisGeneralRepository analisisGeneralRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository, ModelMapper modelMapper) {
        this.analisisGeneralRepository = analisisGeneralRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveAnalisisGeneral(CrearAnalisisGeneralDTO crearAnalisisGeneralDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AnalisisGeneralEntity analisisGeneralEntity = new AnalisisGeneralEntity();
        Optional<EspecialidadEntity> especialidadEntity = especialidadRepository.findById(crearAnalisisGeneralDTO.getEspecialidadId());
        especialidadEntity.ifPresent(analisisGeneralEntity::setEspecialidadEntity);
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(crearAnalisisGeneralDTO.getDoctorId());
        doctorEntity.ifPresent(analisisGeneralEntity::setDoctorEntity);
        analisisGeneralEntity.setTipoOrtodoncia(crearAnalisisGeneralDTO.getTipoOrtodoncia());
        analisisGeneralEntity.setDuracionOrtodoncia(crearAnalisisGeneralDTO.getDuracionOrtodoncia());
        analisisGeneralEntity.setFechaInicioOrtodoncia(crearAnalisisGeneralDTO.getFechaInicioOrtodoncia());
        analisisGeneralEntity.setFechaFinOrtodoncia(crearAnalisisGeneralDTO.getFechaFinOrtodoncia());
        analisisGeneralEntity.setAnclajeSuperiorOrtodoncia(crearAnalisisGeneralDTO.getAnclajeSuperiorOrtodoncia());
        analisisGeneralEntity.setAnclajeInferiorOrtodoncia(crearAnalisisGeneralDTO.getAnclajeInferiorOrtodoncia());
        analisisGeneralEntity.setNotaOrtodoncia(crearAnalisisGeneralDTO.getNotaOrtodoncia());
        analisisGeneralEntity.setHospital(hospital);
        analisisGeneralEntity.setUser(user);
        analisisGeneralRepository.save(analisisGeneralEntity);
        return new ApiResponse(true, "Analisis general guardado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateAnalisisGeneral(UUID pacienteAnalisisGeneralId, ActualizarAnalisisGeneralDTO actualizarAnalisisGeneralDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AnalisisGeneralEntity analisisGeneralEntity = analisisGeneralRepository.findById(pacienteAnalisisGeneralId).orElseThrow(
                () -> new ResourceNotFoundException("Analisis general no encontrado"));
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getEspecialidadId()).flatMap(especialidadRepository::findById).ifPresent(analisisGeneralEntity::setEspecialidadEntity);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getDoctorId()).flatMap(doctorRepository::findById).ifPresent(analisisGeneralEntity::setDoctorEntity);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getTipoOrtodoncia()).filter(desc -> !desc.isBlank()).ifPresent(analisisGeneralEntity::setTipoOrtodoncia);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getDuracionOrtodoncia()).filter(desc -> !desc.isBlank()).ifPresent(analisisGeneralEntity::setTipoOrtodoncia);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getFechaInicioOrtodoncia()).ifPresent(analisisGeneralEntity::setFechaInicioOrtodoncia);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getFechaFinOrtodoncia()).ifPresent(analisisGeneralEntity::setFechaFinOrtodoncia);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getAnclajeSuperiorOrtodoncia()).filter(desc -> !desc.isBlank()).ifPresent(analisisGeneralEntity::setTipoOrtodoncia);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getAnclajeInferiorOrtodoncia()).filter(desc -> !desc.isBlank()).ifPresent(analisisGeneralEntity::setTipoOrtodoncia);
        Optional.ofNullable(actualizarAnalisisGeneralDTO.getNotaOrtodoncia()).filter(desc -> !desc.isBlank()).ifPresent(analisisGeneralEntity::setTipoOrtodoncia);
        analisisGeneralRepository.save(analisisGeneralEntity);
        return new ApiResponse(true, "Amalisis general actualizado correctamente");
    }

    @Override
    public ListResponse<AnalisisGeneralDTO> getAllAnalisisGeneral(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AnalisisGeneralEntity> analisisGeneralEntityPage = analisisGeneralRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AnalisisGeneralDTO> data = analisisGeneralEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, analisisGeneralEntityPage.getTotalElements(), analisisGeneralEntityPage.getTotalPages(), analisisGeneralEntityPage.getNumber() + 1);
    }

    @Override
    public AnalisisGeneralDTO getAnalisisGeneralById(UUID pacienteAnalisisGeneralId) {
        AnalisisGeneralEntity analisisGeneralEntity = analisisGeneralRepository.findById(pacienteAnalisisGeneralId).orElseThrow(
                () -> new ResourceNotFoundException("Analisis general no encontrado"));
        return convertToDTO(analisisGeneralEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteAnalisisGeneral(UUID pacienteAnalisisGeneralId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AnalisisGeneralEntity analisisGeneralEntity = analisisGeneralRepository.findById(pacienteAnalisisGeneralId).orElseThrow(
                () -> new ResourceNotFoundException("Analisis general no encontrado"));
        analisisGeneralRepository.deleteById(pacienteAnalisisGeneralId);
        return new ApiResponse(true, "Analisis general eliminado correctamente");
    }

    private AnalisisGeneralDTO convertToDTO(AnalisisGeneralEntity analisisGeneralEntity) {
        return modelMapper.map(analisisGeneralEntity, AnalisisGeneralDTO.class);
    }

}