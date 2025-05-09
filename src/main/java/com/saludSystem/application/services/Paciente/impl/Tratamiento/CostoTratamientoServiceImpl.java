package com.saludSystem.application.services.Paciente.impl.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.CostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearCostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarCostoTratamientoDTO;
import com.saludSystem.application.services.Paciente.Tratamiento.CostoTratamientoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.domain.model.Paciente.Tratamiento.CostoTratamientoEntity;
import com.saludSystem.domain.model.Paciente.Tratamiento.PlanTratamientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento.CostoTratamientoRepository;
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
public class CostoTratamientoServiceImpl implements CostoTratamientoService {

    private final CostoTratamientoRepository costoTratamientoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final PlanTratamientoRepository planTratamientoRepository;
    private final ModelMapper modelMapper;

    public CostoTratamientoServiceImpl(CostoTratamientoRepository costoTratamientoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, PlanTratamientoRepository planTratamientoRepository, ModelMapper modelMapper) {
        this.costoTratamientoRepository = costoTratamientoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.planTratamientoRepository = planTratamientoRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCostoTratamiento(CrearCostoTratamientoDTO crearCostoTratamientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        CostoTratamientoEntity costoTratamientoEntity = new CostoTratamientoEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearCostoTratamientoDTO.getPacienteId());
        pacienteEntity.ifPresent(costoTratamientoEntity::setPacienteEntity);
        Optional<PlanTratamientoEntity> planTratamientoEntity = planTratamientoRepository.findById(crearCostoTratamientoDTO.getPacientePlanTratamientoId());
        planTratamientoEntity.ifPresent(costoTratamientoEntity::setPlanTratamientoEntity);
        costoTratamientoEntity.setConcepto(crearCostoTratamientoDTO.getConcepto());
        costoTratamientoEntity.setMonto(crearCostoTratamientoDTO.getMonto());
        costoTratamientoEntity.setMoneda(crearCostoTratamientoDTO.getMoneda());
        costoTratamientoEntity.setPagado(costoTratamientoEntity.isPagado());
        costoTratamientoEntity.setHospital(hospital);
        costoTratamientoEntity.setUser(user);
        costoTratamientoRepository.save(costoTratamientoEntity);
        return new ApiResponse(true, "Costo de tratamiento agregado correctamente");
    }

    @Override
    public ListResponse<CostoTratamientoDTO> getAllCostoTratamiento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CostoTratamientoEntity> costoTratamientoEntityPage = costoTratamientoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CostoTratamientoDTO> data = costoTratamientoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, costoTratamientoEntityPage.getTotalElements(), costoTratamientoEntityPage.getTotalPages(), costoTratamientoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCostoTratamiento(UUID pacienteCostoTratamientoId, ActualizarCostoTratamientoDTO actualizarCostoTratamientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        CostoTratamientoEntity costoTratamientoEntity = costoTratamientoRepository.findById(pacienteCostoTratamientoId).orElseThrow(
                () -> new ResourceNotFoundException("Registro del costo de tratamiento no econtrado"));
        Optional.ofNullable(actualizarCostoTratamientoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(costoTratamientoEntity::setPacienteEntity);
        Optional.ofNullable(actualizarCostoTratamientoDTO.getPacienteCostoTratamientoId()).flatMap(planTratamientoRepository::findById).ifPresent(costoTratamientoEntity::setPlanTratamientoEntity);
        Optional.ofNullable(actualizarCostoTratamientoDTO.getConcepto()).filter(desc -> !desc.isBlank()).ifPresent(costoTratamientoEntity::setConcepto);
        Optional.ofNullable(actualizarCostoTratamientoDTO.getMonto()).ifPresent(costoTratamientoEntity::setMonto);
        Optional.ofNullable(actualizarCostoTratamientoDTO.getMoneda()).filter(desc -> !desc.isBlank()).ifPresent(costoTratamientoEntity::setMoneda);
        Optional.ofNullable(actualizarCostoTratamientoDTO.isPagado()).ifPresent(costoTratamientoEntity::setPagado);
        costoTratamientoRepository.save(costoTratamientoEntity);
        return new ApiResponse(true, "Costo de tratamiento modificado correctamente");
    }

    @Override
    public CostoTratamientoDTO getCostoTratamientoById(UUID pacienteCostoTratamientoId) {
        CostoTratamientoEntity costoTratamientoEntity = costoTratamientoRepository.findById(pacienteCostoTratamientoId).orElseThrow(
                () -> new ResourceNotFoundException("Registro del costo de tratamiento no econtrado"));
        return convertToDTO(costoTratamientoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCostoTratamiento(UUID pacienteCostoTratamientoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        costoTratamientoRepository.deleteById(pacienteCostoTratamientoId);
        return new ApiResponse(true, "Costo de tratamiento eliminado correctamente");
    }

    private CostoTratamientoDTO convertToDTO(CostoTratamientoEntity costoTratamientoEntity) {
        return modelMapper.map(costoTratamientoEntity, CostoTratamientoDTO.class);
    }

}