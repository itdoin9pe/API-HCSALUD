package com.saludSystem.application.services.Paciente.impl.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.ProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarProcedimientoDTO;
import com.saludSystem.application.services.Paciente.Tratamiento.ProcedimientoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Medico.DoctorEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.domain.model.Paciente.Tratamiento.ProcedimientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento.ProcedimientoRepository;
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
public class ProcedimientoServiceImpl implements ProcedimientoService {

    private final ProcedimientoRepository procedimientoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public ProcedimientoServiceImpl(ProcedimientoRepository procedimientoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.procedimientoRepository = procedimientoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveProcedimiento(CrearProcedimientoDTO crearProcedimientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        ProcedimientoEntity procedimientoEntity = new ProcedimientoEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearProcedimientoDTO.getPacienteId());
        pacienteEntity.ifPresent(procedimientoEntity::setPacienteEntity);
        Optional<DoctorEntity> doctorEntity = doctorRepository.findById(crearProcedimientoDTO.getDoctorId());
        doctorEntity.ifPresent(procedimientoEntity::setDoctorEntity);
        procedimientoEntity.setTipoProcedimiento(crearProcedimientoDTO.getTipoProcedimiento());
        procedimientoEntity.setDescripcion(crearProcedimientoDTO.getDescripcion());
        procedimientoEntity.setFecha(crearProcedimientoDTO.getFecha());
        procedimientoEntity.setResultado(crearProcedimientoDTO.getResultado());
        procedimientoEntity.setHospital(hospital);
        procedimientoEntity.setUser(user);
        procedimientoRepository.save(procedimientoEntity);
        return new ApiResponse(true, "Procedimiento creado correctamente");
    }

    @Override
    public ListResponse<ProcedimientoDTO> getAllProcedimiento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ProcedimientoEntity> procedimientoEntityPage = procedimientoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ProcedimientoDTO> data = procedimientoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, procedimientoEntityPage.getTotalElements(), procedimientoEntityPage.getTotalPages(), procedimientoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateProcedimiento(UUID pacienteProcedimientoId, ActualizarProcedimientoDTO actualizarProcedimientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        ProcedimientoEntity procedimientoEntity = procedimientoRepository.findById(pacienteProcedimientoId).orElseThrow(
                () -> new ResourceNotFoundException("Procedimiento no encontrado"));
        Optional.ofNullable(actualizarProcedimientoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(procedimientoEntity::setPacienteEntity);
        Optional.ofNullable(actualizarProcedimientoDTO.getDoctorId()).flatMap(doctorRepository::findById).ifPresent(procedimientoEntity::setDoctorEntity);
        Optional.ofNullable(actualizarProcedimientoDTO.getTipoProcedimiento()).ifPresent(procedimientoEntity::setTipoProcedimiento);
        Optional.ofNullable(actualizarProcedimientoDTO.getDescripcion()).ifPresent(procedimientoEntity::setDescripcion);
        Optional.ofNullable(actualizarProcedimientoDTO.getFecha()).ifPresent(procedimientoEntity::setFecha);
        Optional.ofNullable(actualizarProcedimientoDTO.getResultado()).ifPresent(procedimientoEntity::setResultado);
        procedimientoRepository.save(procedimientoEntity);
        return new ApiResponse(true, "Procedimiento actualizado correctamente");
    }

    @Override
    public ProcedimientoDTO getProcedimientoById(UUID pacienteProcedimientoId) {
        ProcedimientoEntity procedimientoEntity = procedimientoRepository.findById(pacienteProcedimientoId).orElseThrow(
                () -> new ResourceNotFoundException("Procedimiento no encontrado"));
        return convertToDTO(procedimientoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteProcedimiento(UUID pacienteProcedimientoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        procedimientoRepository.deleteById(pacienteProcedimientoId);
        return new ApiResponse(true, "Procedimiento eliminado correctamente");
    }

    private ProcedimientoDTO convertToDTO(ProcedimientoEntity procedimientoEntity) {
        return modelMapper.map(procedimientoEntity, ProcedimientoDTO.class);
    }

}