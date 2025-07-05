package com.saludsystem.application.services.paciente.impl.historialClinico.tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialClinico.tratamiento.PlanTratamientoService;
import com.saludsystem.domain.model.paciente.Tratamiento.PlanTratamientoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.EspecialidadRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.MedidaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.Tratamiento.PlanTratamientoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlanTratamientoServiceImpl extends GenericServiceImpl<PlanTratamientoEntity, PlanTratamientoDTO, UUID,
        CrearPlanTratamientoDTO, ActualizarPlanTratamientoDTO> implements PlanTratamientoService {

    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;
    private final DoctorRepository doctorRepository;
    private final MedidaRepository medidaRepository;

    public PlanTratamientoServiceImpl(
            PlanTratamientoRepository planTratamientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository,
            DoctorRepository doctorRepository, MedidaRepository medidaRepository) {
        super(planTratamientoRepository, modelMapper, authValidator, PlanTratamientoDTO.class,
                planTratamientoEntity -> modelMapper.map(planTratamientoEntity, PlanTratamientoDTO.class));
        this.pacienteRepository = pacienteRepository;
        this.especialidadRepository = especialidadRepository;
        this.doctorRepository = doctorRepository;
        this.medidaRepository = medidaRepository;
    }

    @Override
    protected PlanTratamientoEntity convertCreateDtoToEntity(CrearPlanTratamientoDTO crearPlanTratamientoDTO) {
        PlanTratamientoEntity entity = new PlanTratamientoEntity();
        pacienteRepository.findById(crearPlanTratamientoDTO.getPacienteId()).ifPresent(entity::setPacienteEntity);
        doctorRepository.findById(crearPlanTratamientoDTO.getDoctorId()).ifPresent(entity::setDoctorEntity);
        especialidadRepository.findById(crearPlanTratamientoDTO.getEspecialidadId()).ifPresent(entity::setEspecialidadEntity);
        medidaRepository.findById(crearPlanTratamientoDTO.getMedidaId()).ifPresent(entity::setMedidaEntity);
        entity.setFechaInicio(crearPlanTratamientoDTO.getFechaInicio());
        entity.setFechaFin(crearPlanTratamientoDTO.getFechaFin());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarPlanTratamientoDTO actualizarPlanTratamientoDTO, PlanTratamientoEntity entity) {
        Optional.ofNullable(actualizarPlanTratamientoDTO.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getEspecialidadId())
                .flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getMedidaId())
                .flatMap(medidaRepository::findById)
                .ifPresent(entity::setMedidaEntity);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getFechaInicio()).ifPresent(entity::setFechaInicio);
        Optional.ofNullable(actualizarPlanTratamientoDTO.getFechaFin()).ifPresent(entity::setFechaFin);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPlanTratamientoDTO crearPlanTratamientoDTO) {
        return super.save(crearPlanTratamientoDTO);
    }

    @Override
    public ListResponse<PlanTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPlanTratamientoDTO actualizarPlanTratamientoDTO) {
        return super.update(uuid, actualizarPlanTratamientoDTO);
    }

    @Override
    public PlanTratamientoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PlanTratamientoDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}