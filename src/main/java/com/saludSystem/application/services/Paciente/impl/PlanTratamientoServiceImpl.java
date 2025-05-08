package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.PlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPlanTratamientoDTO;
import com.saludSystem.application.services.Paciente.PlanTratamientoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.EspecialidadEntity;
import com.saludSystem.domain.model.Catalogo.MedidaEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Medico.DoctorEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.domain.model.Paciente.Tratamiento.PlanTratamientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.EspecialidadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedidaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento.PlanTratamientoRepository;
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
public class PlanTratamientoServiceImpl implements PlanTratamientoService {

    private final PlanTratamientoRepository planTratamientoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;
    private final DoctorRepository doctorRepository;
    private final MedidaRepository medidaRepository;
    private final ModelMapper modelMapper;

    public PlanTratamientoServiceImpl(PlanTratamientoRepository planTratamientoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository, DoctorRepository doctorRepository, MedidaRepository medidaRepository, ModelMapper modelMapper) {
        this.planTratamientoRepository = planTratamientoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.especialidadRepository = especialidadRepository;
        this.doctorRepository = doctorRepository;
        this.medidaRepository = medidaRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse savePlanTratamiento(CrearPlanTratamientoDTO crearPlanTratamientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        PlanTratamientoEntity planTratamientoEntity = new PlanTratamientoEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearPlanTratamientoDTO.getPacienteId());
        pacienteEntity.ifPresent(planTratamientoEntity::setPacienteEntity);
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(crearPlanTratamientoDTO.getDoctorId());
        doctorEntity.ifPresent(planTratamientoEntity::setDoctorEntity);
        Optional<EspecialidadEntity> especialidadEntity = especialidadRepository.findById(crearPlanTratamientoDTO.getEspecialidadId());
        especialidadEntity.ifPresent(planTratamientoEntity::setEspecialidadEntity);
        Optional<MedidaEntity> medidaEntity = medidaRepository.findById(crearPlanTratamientoDTO.getMedidaId());
        medidaEntity.ifPresent(planTratamientoEntity::setMedidaEntity);
        planTratamientoEntity.setFechaFin(crearPlanTratamientoDTO.getFechaFin());
        planTratamientoEntity.setFechaInicio(crearPlanTratamientoDTO.getFechaInicio());
        planTratamientoEntity.setHospital(hospital);
        planTratamientoEntity.setUser(user);
        planTratamientoRepository.save(planTratamientoEntity);
        return new ApiResponse(true, "Plan de tratamiento agregado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')") @Override
    public ApiResponse updatePlanTratamiento(UUID pacientePlanTratamientoId, ActualizarPlanTratamientoDTO actualizarPlanTratamientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        PlanTratamientoEntity planTratamientoEntity = planTratamientoRepository.findById(pacientePlanTratamientoId).
                orElseThrow( () -> new ResourceNotFoundException("Plan de tratamiento no encontrado"));
        Optional.ofNullable(actualizarPlanTratamientoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(planTratamientoEntity::setPacienteEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getDoctorId()).flatMap(doctorRepository::findById).ifPresent(planTratamientoEntity::setDoctorEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getEspecialidadId()).flatMap(especialidadRepository::findById).ifPresent(planTratamientoEntity::setEspecialidadEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getMedidaId()).flatMap(medidaRepository::findById).ifPresent(planTratamientoEntity::setMedidaEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getFechaInicio()).ifPresent(planTratamientoEntity::setFechaInicio);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getFechaFin()).ifPresent(planTratamientoEntity::setFechaFin);
        planTratamientoRepository.save(planTratamientoEntity);
        return new ApiResponse(true, "Plan de tratamiento modificado correctamente");
    }

    @Override
    public ListResponse<PlanTratamientoDTO> getAllPlanTratamiento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PlanTratamientoEntity> planTratamientoEntityPage = planTratamientoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PlanTratamientoDTO> data = planTratamientoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, planTratamientoEntityPage.getTotalElements(), planTratamientoEntityPage.getTotalPages(), planTratamientoEntityPage.getNumber() + 1);
    }

    @Override
    public PlanTratamientoDTO getPlanTratamientoById(UUID pacientePlanTratamientoId) {
        PlanTratamientoEntity planTratamientoEntity = planTratamientoRepository.findById(pacientePlanTratamientoId).
                orElseThrow( () -> new ResourceNotFoundException("Plan de tratamiento no encontrado"));
        return convertToDTO(planTratamientoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deletePlanTratamiento(UUID pacientePlanTratamientoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        planTratamientoRepository.deleteById(pacientePlanTratamientoId);
        return new ApiResponse(true, "Plan de tratamiento eliminado correctamente");
    }

    private PlanTratamientoDTO convertToDTO(PlanTratamientoEntity planTratamientoEntity) {
        return modelMapper.map(planTratamientoEntity, PlanTratamientoDTO.class);
    }

}