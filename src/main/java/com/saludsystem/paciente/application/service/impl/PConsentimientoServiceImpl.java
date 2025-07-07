package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.res.HoraDTO;
import com.saludsystem.paciente.application.dto.res.PConsentimientoDTO;
import com.saludsystem.paciente.application.dto.req.CrearPConsentimientoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.PConsentimientoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.PConsentimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ConsentimientoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PConsentimientoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PConsentimientoServiceImpl extends GenericServiceImpl<PConsentimientoEntity, CrearPConsentimientoDTO,
        PConsentimientoDTO, UUID> implements PConsentimientoService {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsentimientoRepository consentimientoRepository;

    public PConsentimientoServiceImpl(
            PConsentimientoRepository pConsentimientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            DoctorRepository doctorRepository, PacienteRepository pacienteRepository, ConsentimientoRepository consentimientoRepository) {
        super(pConsentimientoRepository, modelMapper, authValidator, PConsentimientoDTO.class
        );
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.consentimientoRepository = consentimientoRepository;
    }

    @Override
    protected PConsentimientoEntity convertCreateDtoToEntity(CrearPConsentimientoDTO crearPConsentimientoDTO) {
        PConsentimientoEntity entity = new PConsentimientoEntity();
        entity.setDoctorEntity(doctorRepository.findById(crearPConsentimientoDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado")));
        entity.setFecha(crearPConsentimientoDTO.getFecha());
        // Convertir HoraDTO a LocalTime
        HoraDTO horaDTO = crearPConsentimientoDTO.getHora();
        LocalTime hora = LocalTime.of(
                horaDTO.getHours(),
                horaDTO.getMinutes(),
                horaDTO.getSeconds()
        );
        entity.setHora(hora);
        entity.setApoderadoNombre(crearPConsentimientoDTO.getApoderadoNombre());
        entity.setApoderadoDocumento(crearPConsentimientoDTO.getApoderadoDocumento());
        entity.setApoderadoDireccion(crearPConsentimientoDTO.getApoderadoDireccion());
        entity.setConsentimientoEntity(consentimientoRepository.findById(crearPConsentimientoDTO.getConsentimientoId())
                .orElseThrow(() -> new ResourceNotFoundException("Consentimiento no encontrado")));
        entity.setPacienteEntity(pacienteRepository.findById(crearPConsentimientoDTO.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado")));
        entity.setCuerpo(crearPConsentimientoDTO.getCuerpo());
        entity.setFirma(crearPConsentimientoDTO.getFirma());
        entity.setEstado(crearPConsentimientoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PConsentimientoEntity entity, CrearPConsentimientoDTO dto) {
        Optional.ofNullable(dto.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getFecha())
                .ifPresent(entity::setFecha);
        Optional.ofNullable(dto.getHora())
                .ifPresent(horaDTO -> entity.setHora(LocalTime.of(
                        horaDTO.getHours(),
                        horaDTO.getMinutes(),
                        horaDTO.getSeconds()
                )));
        Optional.ofNullable(dto.getApoderadoNombre())
                .ifPresent(entity::setApoderadoNombre);
        Optional.ofNullable(dto.getApoderadoDocumento())
                .ifPresent(entity::setApoderadoDocumento);
        Optional.ofNullable(dto.getApoderadoDireccion())
                .ifPresent(entity::setApoderadoDireccion);
        Optional.ofNullable(dto.getConsentimientoId())
                .flatMap(consentimientoRepository::findById)
                .ifPresent(entity::setConsentimientoEntity);
        Optional.ofNullable(dto.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getCuerpo())
                .ifPresent(entity::setCuerpo);
        Optional.ofNullable(dto.getFirma())
                .ifPresent(entity::setFirma);
        Optional.ofNullable(dto.getEstado())
                .ifPresent(entity::setEstado);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPConsentimientoDTO crearPConsentimientoDTO) {
        return super.save(crearPConsentimientoDTO);
    }

    @Override
    public ListResponse<PConsentimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearPConsentimientoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public PConsentimientoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PConsentimientoDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}