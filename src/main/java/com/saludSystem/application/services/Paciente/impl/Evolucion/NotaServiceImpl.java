package com.saludSystem.application.services.Paciente.impl.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.NotaDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearNotaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarNotaDTO;
import com.saludSystem.application.services.Paciente.Evolucion.NotaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.Evolucion.NotaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.EvolucionRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Evolucion.NotaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final AuthValidator authValidator;
    private final EvolucionRepository evolucionRepository;
    private final ModelMapper modelMapper;

    public NotaServiceImpl(NotaRepository notaRepository, SysSaludRepository sysSaludRepository, AuthValidator authValidator, EvolucionRepository evolucionRepository, ModelMapper modelMapper) {
        this.notaRepository = notaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.authValidator = authValidator;
        this.evolucionRepository = evolucionRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveNota(CrearNotaDTO crearNotaDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        var notaEntity = new NotaEntity();
        notaEntity.setEvolucionEntity(evolucionRepository.findById(crearNotaDTO.getPacienteEvolucionId()).orElseThrow(
                () -> new RequestRejectedException("Nota de evolucion no encontrada")));
        notaEntity.setFecha(crearNotaDTO.getFecha());
        notaEntity.setTipo(crearNotaDTO.getTipo());
        notaEntity.setContenido(crearNotaDTO.getContenido());
        notaEntity.setHospital(hospital);
        notaEntity.setUser(user);
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
        authValidator.validateAdminAccess();
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
        authValidator.validateAdminAccess();
        notaRepository.deleteById(pacienteEvolucionNotaId);
        return new ApiResponse(true, "Nota de evolucion eliminada correctamente");
    }

    private NotaDTO convertToDTO(NotaEntity notaEntity) {
        return modelMapper.map(notaEntity, NotaDTO.class);
    }
}