package com.saludSystem.application.services.Paciente.impl.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarExploracionFisicaDTO;
import com.saludSystem.application.services.Paciente.HistorialClinico.ExploracionFisicaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.HistorialClinico.ExploracionFisicaEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico.ExploracionFisicaRepository;
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
public class ExploracionFisicaServiceImpl implements ExploracionFisicaService {

    private final ExploracionFisicaRepository exploracionFisicaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public ExploracionFisicaServiceImpl(ExploracionFisicaRepository exploracionFisicaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.exploracionFisicaRepository = exploracionFisicaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveExploracionFisica(CrearExploracionFisicaDTO crearExploracionFisicaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        ExploracionFisicaEntity exploracionFisicaEntity = new ExploracionFisicaEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearExploracionFisicaDTO.getPacienteId());
        pacienteEntity.ifPresent(exploracionFisicaEntity::setPacienteEntity);
        exploracionFisicaEntity.setPresionArterial(crearExploracionFisicaDTO.getPresionArterial());
        exploracionFisicaEntity.setPulso(crearExploracionFisicaDTO.getPulso());
        exploracionFisicaEntity.setTemperatura(crearExploracionFisicaDTO.getTemperatura());
        exploracionFisicaEntity.setFrecuenciaCardiaca(crearExploracionFisicaDTO.getFrecuenciaCardiaca());
        exploracionFisicaEntity.setFrecuenciaRespiratoria(crearExploracionFisicaDTO.getFrecuenciaRespiratoria());
        exploracionFisicaEntity.setPeso(crearExploracionFisicaDTO.getPeso());
        exploracionFisicaEntity.setTalla(crearExploracionFisicaDTO.getTalla());
        exploracionFisicaEntity.setMasa(crearExploracionFisicaDTO.getMasa());
        exploracionFisicaEntity.setExamenClinico(crearExploracionFisicaDTO.getExamenClinico());
        exploracionFisicaEntity.setComplementoExamen(crearExploracionFisicaDTO.getComplementoExamen());
        exploracionFisicaRepository.save(exploracionFisicaEntity);
        return new ApiResponse(true, "Exploracion fisica creada correctamente");
    }

    @Override
    public ExploracionFisicaDTO getExploracionFisicaById(UUID pacienteExploracionId) {
        ExploracionFisicaEntity exploracionFisicaEntity = exploracionFisicaRepository.findById(pacienteExploracionId)
                .orElseThrow( () -> new ResourceNotFoundException("Exploracion fisica no encontrada"));
        return convertToDTO(exploracionFisicaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateExploracionFisica(UUID pacienteExploracionId, ActualizarExploracionFisicaDTO actualizarExploracionFisicaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        ExploracionFisicaEntity exploracionFisicaEntity = exploracionFisicaRepository.findById(pacienteExploracionId)
                .orElseThrow( () -> new ResourceNotFoundException("Exploracion fisica no encontrada"));
        Optional.ofNullable(actualizarExploracionFisicaDTO.getPresionArterial()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setPresionArterial);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getPulso()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setPulso);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getTemperatura()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setTemperatura);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getFrecuenciaCardiaca()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setFrecuenciaCardiaca);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getFrecuenciaRespiratoria()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setFrecuenciaRespiratoria);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getPeso()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setPeso);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getTalla()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setTalla);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getMasa()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setMasa);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getExamenClinico()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setExamenClinico);
        Optional.ofNullable(actualizarExploracionFisicaDTO.getComplementoExamen()).filter(desc -> !desc.isBlank()).ifPresent(exploracionFisicaEntity::setComplementoExamen);
        exploracionFisicaRepository.save(exploracionFisicaEntity);
        return new ApiResponse(true, "Exploracion fisica modificada correctamente");
    }

    @Override
    public ListResponse<ExploracionFisicaDTO> getAllExploracionFisica(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ExploracionFisicaEntity> exploracionFisicaEntityPage = exploracionFisicaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ExploracionFisicaDTO> data = exploracionFisicaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, exploracionFisicaEntityPage.getTotalElements(), exploracionFisicaEntityPage.getTotalPages(), exploracionFisicaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteExploracionFisica(UUID pacienteExploracionId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        exploracionFisicaRepository.deleteById(pacienteExploracionId);
        return new ApiResponse(true, "Exploracion fisica eliminada correctamente");
    }

    private ExploracionFisicaDTO convertToDTO(ExploracionFisicaEntity exploracionFisicaEntity) {
        return modelMapper.map(exploracionFisicaEntity, ExploracionFisicaDTO.class);
    }

}