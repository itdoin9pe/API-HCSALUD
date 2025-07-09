package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.get.EstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.post.CrearEstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarEstudioMedicoDTO;
import com.saludsystem.paciente.application.service.EstudioMedicoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstudioMedicoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstudioMedicoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudioMedicoServiceImpl implements EstudioMedicoService {

    private final EstudioMedicoRepository estudioMedicoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final AuthValidator authValidator;

    public EstudioMedicoServiceImpl(EstudioMedicoRepository estudioMedicoRepository, SysSaludRepository sysSaludRepository, PacienteRepository pacienteRepository, DoctorRepository doctorRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        this.estudioMedicoRepository = estudioMedicoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveEstudioMedico(CrearEstudioMedicoDTO crearEstudioMedicoDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
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
        estudioMedicoEntity.setUser(user);
        estudioMedicoRepository.save(estudioMedicoEntity);
        return new ApiResponse(true, "Estudio medico creado correctamente");
    }

    @Override
    public ListResponse<EstudioMedicoDTO> getAllEstudioMedico(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<EstudioMedicoEntity> estudioMedicoEntityPage = estudioMedicoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<EstudioMedicoDTO> data = estudioMedicoEntityPage.getContent().stream().map(this::convertToDTO).toList();
        return new ListResponse<>(data, estudioMedicoEntityPage.getTotalElements(), estudioMedicoEntityPage.getTotalPages(), estudioMedicoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateEstudioMedico(Long pacienteEstudioMedicoId, ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO) {
        authValidator.validateAdminAccess();
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
        authValidator.validateAdminAccess();
        estudioMedicoRepository.deleteById(pacienteEstudioMedicoId);
        return new ApiResponse(true, "Estudio nedico eliminado correctamente");
    }

    private EstudioMedicoDTO convertToDTO(EstudioMedicoEntity estudioMedicoEntity) {
        return modelMapper.map(estudioMedicoEntity, EstudioMedicoDTO.class);
    }
}