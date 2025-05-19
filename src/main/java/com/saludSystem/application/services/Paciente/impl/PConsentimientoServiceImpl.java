package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.HoraDTO;
import com.saludSystem.application.dtos.Paciente.GET.PConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPConsentimiento;
import com.saludSystem.application.services.Paciente.PConsentimientoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.PConsentimientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ConsentimientoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PConsentimientoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PConsentimientoServiceImpl implements PConsentimientoService {

    private final PConsentimientoRepository pConsentimientoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsentimientoRepository consentimientoRepository;
    private final ModelMapper modelMapper;

    public PConsentimientoServiceImpl(PConsentimientoRepository pConsentimientoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository, ConsentimientoRepository consentimientoRepository, ModelMapper modelMapper) {
        this.pConsentimientoRepository = pConsentimientoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.consentimientoRepository = consentimientoRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse savePConsentiemiento(CrearPConsentimientoDTO crearPConsentimientoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        PConsentimientoEntity pConsentimientoEntity = new PConsentimientoEntity();
        pConsentimientoEntity.setDoctorEntity(doctorRepository.findById(crearPConsentimientoDTO.getDoctorId()).orElseThrow(
                () -> new ResourceNotFoundException("Doctor no encontrado")));
        pConsentimientoEntity.setFecha(crearPConsentimientoDTO.getFecha());
        HoraDTO horaDTO = crearPConsentimientoDTO.getHora();
        LocalTime hora = LocalTime.of(
                horaDTO.getHours(),
                horaDTO.getMinutes(),
                horaDTO.getSeconds()
        );
        pConsentimientoEntity.setHora(hora);
        pConsentimientoEntity.setApoderadoNombre(crearPConsentimientoDTO.getApoderadoNombre());
        pConsentimientoEntity.setApoderadoDocumento(crearPConsentimientoDTO.getApoderadoDocumento());
        pConsentimientoEntity.setApoderadoDireccion(crearPConsentimientoDTO.getApoderadoDireccion());
        pConsentimientoEntity.setConsentimientoEntity(consentimientoRepository.findById(crearPConsentimientoDTO.getConsentimientoId()).orElseThrow(
                () -> new ResourceNotFoundException("Consentimiento no encontrado")));
        pConsentimientoEntity.setPacienteEntity(pacienteRepository.findById(crearPConsentimientoDTO.getPacienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Paciente no encontrado")));
        pConsentimientoEntity.setCuerpo(crearPConsentimientoDTO.getCuerpo());
        pConsentimientoEntity.setFirma(crearPConsentimientoDTO.getFirma());
        pConsentimientoEntity.setEstado(crearPConsentimientoDTO.getEstado());
        pConsentimientoEntity.setHospital(hospital);
        pConsentimientoEntity.setUser(userEntity);
        pConsentimientoRepository.save(pConsentimientoEntity);
        return new ApiResponse(true, "Consentimiento del paciente agregado");
    }

    @Override
    public List<PConsentimientoDTO> getPConsentimientoList() {
        return pConsentimientoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<PConsentimientoDTO> getAllPConsentimiento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PConsentimientoEntity> pConsentimientoEntityPage = pConsentimientoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PConsentimientoDTO> data = pConsentimientoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, pConsentimientoEntityPage.getTotalElements(), pConsentimientoEntityPage.getTotalPages(), pConsentimientoEntityPage.getNumber() + 1);
    }

    @Override
    public PConsentimientoDTO getPConsentimientoById(UUID pacienteConsentimientoId) {
        PConsentimientoEntity pConsentimientoEntity = pConsentimientoRepository.findById(pacienteConsentimientoId).orElseThrow(
                () -> new ResourceNotFoundException("Consentimiento del paciente no encontrado"));
        return convertToDTO(pConsentimientoEntity);
    }

    @Override
    public ApiResponse updatePConsentimiento(UUID pacienteConsentimientoId, ActualizarPConsentimiento actualizarPConsentimiento) {
        PConsentimientoEntity pConsentimientoEntity = pConsentimientoRepository.findById(pacienteConsentimientoId).orElseThrow(
                () -> new ResourceNotFoundException("Consentimiento del paciente no encontrado"));
        Optional.ofNullable(actualizarPConsentimiento.getDoctorId()).flatMap(doctorRepository::findById).ifPresent(pConsentimientoEntity::setDoctorEntity);
        Optional.ofNullable(actualizarPConsentimiento.getFecha()).ifPresent(pConsentimientoEntity::setFecha);
        Optional.ofNullable(actualizarPConsentimiento.getHora()).ifPresent(horaDTO ->
                pConsentimientoEntity.setHora(LocalTime.of(
                        horaDTO.getHours(),
                        horaDTO.getMinutes(),
                        horaDTO.getSeconds()
                ))
        );
        Optional.ofNullable(actualizarPConsentimiento.getApoderadoNombre()).ifPresent(pConsentimientoEntity::setApoderadoNombre);
        Optional.ofNullable(actualizarPConsentimiento.getApoderadoDocumento()).ifPresent(pConsentimientoEntity::setApoderadoDocumento);
        Optional.ofNullable(actualizarPConsentimiento.getApoderadoDireccion()).ifPresent(pConsentimientoEntity::setApoderadoDireccion);
        Optional.ofNullable(actualizarPConsentimiento.getConsentimientoId()).flatMap(consentimientoRepository::findById).ifPresent(pConsentimientoEntity::setConsentimientoEntity);
        Optional.ofNullable(actualizarPConsentimiento.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(pConsentimientoEntity::setPacienteEntity);
        Optional.ofNullable(actualizarPConsentimiento.getCuerpo()).ifPresent(pConsentimientoEntity::setCuerpo);
        Optional.ofNullable(actualizarPConsentimiento.getFirma()).ifPresent(pConsentimientoEntity::setFirma);
        Optional.ofNullable(actualizarPConsentimiento.getEstado()).ifPresent(pConsentimientoEntity::setEstado);
        pConsentimientoRepository.save(pConsentimientoEntity);
        return new ApiResponse(true, "Consentimiento del paciente actualizado");
    }

    @Override
    public ApiResponse deletePConsentimiento(UUID pacienteConsentimientoId) {
        pConsentimientoRepository.deleteById(pacienteConsentimientoId);
        return new ApiResponse(true, "Consentimiento del paciente eliminado");
    }

    private PConsentimientoDTO convertToDTO(PConsentimientoEntity pConsentimientoEntity) {
        return modelMapper.map(pConsentimientoEntity, PConsentimientoDTO.class);
    }

}