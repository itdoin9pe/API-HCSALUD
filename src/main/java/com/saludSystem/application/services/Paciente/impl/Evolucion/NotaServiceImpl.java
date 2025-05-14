package com.saludSystem.application.services.Paciente.impl.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.NotaDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearNotaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarNotaDTO;
import com.saludSystem.application.services.Paciente.Evolucion.NotaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.Evolucion.NotaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.EvolucionRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.NotaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final EvolucionRepository evolucionRepository;
    private final ModelMapper modelMapper;

    public NotaServiceImpl(NotaRepository notaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, EvolucionRepository evolucionRepository, ModelMapper modelMapper) {
        this.notaRepository = notaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.evolucionRepository = evolucionRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveNota(CrearNotaDTO crearNotaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setEvolucionEntity(evolucionRepository.findById(crearNotaDTO.getPacienteEvolucionId()).orElseThrow(
                () -> new RequestRejectedException("Nota de evolucion no encontrada")));
        notaEntity.setFecha(crearNotaDTO.getFecha());
        notaEntity.setTipo(crearNotaDTO.getTipo());
        notaEntity.setContenido(crearNotaDTO.getContenido());
        notaEntity.setHospital(hospital);
        notaEntity.setUser(userEntity);
        notaRepository.save(notaEntity);
        return new ApiResponse(true, "Nota de evolucion creada correctamente");
    }

    @Override
    public NotaDTO getNotaById(Long pacienteEvolucionNotaId) {
        NotaEntity notaEntity = notaRepository.findById(pacienteEvolucionNotaId).orElseThrow(
                () -> new ResourceNotFoundException("Nota de evolucion no encontrada"));
        return convertToDTO(notaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateNota(Long pacienteEvolucionNotaId, ActualizarNotaDTO actualizarNotaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        NotaEntity notaEntity = notaRepository.findById(pacienteEvolucionNotaId).orElseThrow(
                () -> new ResourceNotFoundException("Nota de evolucion no encontrada"));
        Optional.ofNullable(actualizarNotaDTO.getFecha()).ifPresent(notaEntity::setFecha);
        Optional.ofNullable(actualizarNotaDTO.getTipo()).ifPresent(notaEntity::setTipo);
        Optional.ofNullable(actualizarNotaDTO.getContenido()).ifPresent(notaEntity::setContenido);
        notaRepository.save(notaEntity);
        return new ApiResponse(true, "Nota de evolucion actualizada correctamente");
    }

    @Override
    public ListResponse<NotaDTO> getAllNota(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<NotaEntity> notaEntityPage = notaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<NotaDTO> data = notaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, notaEntityPage.getTotalElements(), notaEntityPage.getTotalPages(), notaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteNota(Long pacienteEvolucionNotaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        notaRepository.deleteById(pacienteEvolucionNotaId);
        return new ApiResponse(true, "Nota de evolucion eliminada correctamente");
    }

    private NotaDTO convertToDTO(NotaEntity notaEntity) {
        return modelMapper.map(notaEntity, NotaDTO.class);
    }

}