package com.saludsystem.paciente.application.service.impl.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.PlanTratamientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.PlanTratamientoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.tratamiento.PlanTratamientoService;
import com.saludsystem.paciente.domain.model.Tratamiento.PlanTratamientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedidaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.Tratamiento.PlanTratamientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlanTratamientoServiceImpl extends GenericServiceImpl<PlanTratamientoEntity, PlanTratamientoRequest,
        PlanTratamientoResponse, UUID> implements PlanTratamientoService {

    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;
    private final DoctorRepository doctorRepository;
    private final MedidaRepository medidaRepository;

    public PlanTratamientoServiceImpl(
            PlanTratamientoRepository planTratamientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository,
            DoctorRepository doctorRepository, MedidaRepository medidaRepository) {
        super(planTratamientoRepository, modelMapper, authValidator, PlanTratamientoResponse.class
        );
        this.pacienteRepository = pacienteRepository;
        this.especialidadRepository = especialidadRepository;
        this.doctorRepository = doctorRepository;
        this.medidaRepository = medidaRepository;
    }

    @Override
    protected PlanTratamientoEntity convertCreateDtoToEntity(PlanTratamientoRequest planTratamientoRequest) {
        PlanTratamientoEntity entity = new PlanTratamientoEntity();
        pacienteRepository.findById(planTratamientoRequest.getPacienteId()).ifPresent(entity::setPacienteEntity);
        doctorRepository.findById(planTratamientoRequest.getDoctorId()).ifPresent(entity::setDoctorEntity);
        especialidadRepository.findById(planTratamientoRequest.getEspecialidadId()).ifPresent(entity::setEspecialidadEntity);
        medidaRepository.findById(planTratamientoRequest.getMedidaId()).ifPresent(entity::setMedidaEntity);
        entity.setFechaInicio(planTratamientoRequest.getFechaInicio());
        entity.setFechaFin(planTratamientoRequest.getFechaFin());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PlanTratamientoEntity entity, PlanTratamientoRequest dto) {
        Optional.ofNullable(dto.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getEspecialidadId())
                .flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(dto.getMedidaId())
                .flatMap(medidaRepository::findById)
                .ifPresent(entity::setMedidaEntity);
        Optional.ofNullable(dto.getFechaInicio()).ifPresent(entity::setFechaInicio);
        Optional.ofNullable(dto.getFechaFin()).ifPresent(entity::setFechaFin);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(PlanTratamientoRequest planTratamientoRequest) {
        return super.save(planTratamientoRequest);
    }

    @Override
    public ListResponse<PlanTratamientoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, PlanTratamientoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public PlanTratamientoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PlanTratamientoResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}