package com.saludsystem.cita.application.service;

import com.saludsystem.cita.application.dto.post.CrearCitaDTO;
import com.saludsystem.cita.application.dto.get.CitaDTO;
import com.saludsystem.cita.application.dto.put.ActualizarCitaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.cita.domain.model.CitaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.TipoCitadoRepository;
import com.saludsystem.cita.infrastructure.adapters.out.persistance.CitaRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SedeRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, CitaDTO,
        CrearCitaDTO, ActualizarCitaDTO, UUID> implements CitaService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final PacienteRepository pacienteRepository;
    private final SedeRepository sedeRepository;
    private final TipoCitadoRepository tipoCitadoRepository;

    public CitaServiceImpl(
            CitaRepository citaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository,
            PacienteRepository pacienteRepository, SedeRepository sedeRepository, TipoCitadoRepository tipoCitadoRepository) {
        super(citaRepository, modelMapper, authValidator, CitaDTO.class);
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.pacienteRepository = pacienteRepository;
        this.sedeRepository = sedeRepository;
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    @Override
    protected CitaEntity convertCreateDtoToEntity(CrearCitaDTO citaDTO) {
        CitaEntity entity = new CitaEntity();
        doctorRepository.findById(citaDTO.getDoctorId()).ifPresent(entity::setDoctorEntity);
        especialidadRepository.findById(citaDTO.getEspecialidadId()).ifPresent(entity::setEspecialidadEntity);
        pacienteRepository.findById(citaDTO.getPacienteId()).ifPresent(entity::setPacienteEntity);
        sedeRepository.findById(citaDTO.getSedeId()).ifPresent(entity::setSedeEntity);
        tipoCitadoRepository.findById(citaDTO.getTipoCitadoId()).ifPresent(entity::setTipoCitadoEntity);
        entity.setFecha(citaDTO.getFecha());
        entity.setHoraInicio(citaDTO.getHoraInicio());
        entity.setHoraFin(citaDTO.getHoraFin());
        entity.setEstado(citaDTO.getEstado());
        entity.setMotivoConsulta(citaDTO.getMotivoConsulta());
        entity.setObservacion(citaDTO.getObservacion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CitaEntity entity, ActualizarCitaDTO dto) {
        Optional.ofNullable(dto.getDoctorId()).flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getEspecialidadId()).flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(dto.getPacienteId()).flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getSedeId()).flatMap(sedeRepository::findById)
                .ifPresent(entity::setSedeEntity);
        Optional.ofNullable(dto.getTipoCitadoId()).flatMap(tipoCitadoRepository::findById)
                .ifPresent(entity::setTipoCitadoEntity);
        Optional.ofNullable(dto.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(dto.getHoraInicio()).ifPresent(entity::setHoraInicio);
        Optional.ofNullable(dto.getHoraFin()).ifPresent(entity::setHoraFin);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
        Optional.ofNullable(dto.getMotivoConsulta()).ifPresent(entity::setMotivoConsulta);
        Optional.ofNullable(dto.getObservacion()).ifPresent(entity::setObservacion);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearCitaDTO citaDTO) {
        return super.save(citaDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarCitaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}