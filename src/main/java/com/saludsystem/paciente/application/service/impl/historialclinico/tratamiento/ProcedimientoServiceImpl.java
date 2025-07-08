package com.saludsystem.paciente.application.service.impl.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.ProcedimientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.ProcedimientoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.tratamiento.ProcedimientoService;
import com.saludsystem.paciente.domain.model.Tratamiento.ProcedimientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.Tratamiento.ProcedimientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcedimientoServiceImpl extends GenericServiceImpl<ProcedimientoEntity, ProcedimientoRequest,
        ProcedimientoResponse, UUID> implements ProcedimientoService {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public ProcedimientoServiceImpl(
            ProcedimientoRepository procedimientoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        super(procedimientoRepository, modelMapper, authValidator, ProcedimientoResponse.class
        );
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected ProcedimientoEntity convertCreateDtoToEntity(ProcedimientoRequest procedimientoRequest) {
        ProcedimientoEntity entity = new ProcedimientoEntity();
        doctorRepository.findById(procedimientoRequest.getDoctorId()).ifPresent(entity::setDoctorEntity);
        pacienteRepository.findById(procedimientoRequest.getPacienteId()).ifPresent(entity::setPacienteEntity);
        entity.setTipoProcedimiento(procedimientoRequest.getTipoProcedimiento());
        entity.setDescripcion(procedimientoRequest.getDescripcion());
        entity.setFecha(procedimientoRequest.getFecha());
        entity.setResultado(procedimientoRequest.getResultado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ProcedimientoEntity entity, ProcedimientoRequest dto) {
        Optional.ofNullable(dto.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getTipoProcedimiento()).ifPresent(entity::setTipoProcedimiento);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(dto.getResultado()).ifPresent(entity::setResultado);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(ProcedimientoRequest procedimientoRequest) {
        return super.save(procedimientoRequest);
    }

    @Override
    public ListResponse<ProcedimientoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ProcedimientoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public ProcedimientoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ProcedimientoResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}