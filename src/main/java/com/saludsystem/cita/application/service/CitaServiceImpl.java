package com.saludsystem.cita.application.service;

import com.saludsystem.cita.application.dto.res.CitaResponse;
import com.saludsystem.cita.application.dto.req.CitaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.cita.domain.model.CitaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, CitaRequest, CitaResponse, UUID> implements CitaService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final PacienteRepository pacienteRepository;
    private final SedeRepository sedeRepository;
    private final TipoCitadoRepository tipoCitadoRepository;

    public CitaServiceImpl(
            CitaRepository citaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository,
            PacienteRepository pacienteRepository, SedeRepository sedeRepository, TipoCitadoRepository tipoCitadoRepository) {
        super(citaRepository, modelMapper, authValidator, CitaResponse.class);
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.pacienteRepository = pacienteRepository;
        this.sedeRepository = sedeRepository;
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    @Override
    protected CitaEntity convertCreateDtoToEntity(CitaRequest citaRequest) {
        CitaEntity entity = new CitaEntity();
        doctorRepository.findById(citaRequest.getDoctorEntity()).ifPresent(entity::setDoctorEntity);
        especialidadRepository.findById(citaRequest.getEspecialidadEntity()).ifPresent(entity::setEspecialidadEntity);
        pacienteRepository.findById(citaRequest.getPacienteEntity()).ifPresent(entity::setPacienteEntity);
        sedeRepository.findById(citaRequest.getSedeEntity()).ifPresent(entity::setSedeEntity);
        tipoCitadoRepository.findById(citaRequest.getTipoCitadoEntity()).ifPresent(entity::setTipoCitadoEntity);
        entity.setFecha(citaRequest.getFecha());
        entity.setHoraInicio(citaRequest.getHoraInicio());
        entity.setHoraFin(citaRequest.getHoraFin());
        entity.setEstado(citaRequest.getEstado());
        entity.setMotivoConsulta(citaRequest.getMotivoConsulta());
        entity.setObservacion(citaRequest.getObservacion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CitaEntity entity, CitaRequest dto) {
        Optional.ofNullable(dto.getDoctorEntity()).flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getEspecialidadEntity()).flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(dto.getPacienteEntity()).flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getSedeEntity()).flatMap(sedeRepository::findById)
                .ifPresent(entity::setSedeEntity);
        Optional.ofNullable(dto.getTipoCitadoEntity()).flatMap(tipoCitadoRepository::findById)
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
    public ApiResponse save(CitaRequest citaRequest) {
        return super.save(citaRequest);
    }

    @Override
    public ListResponse<CitaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CitaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public CitaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CitaResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}