package com.saludsystem.paciente.application.service.impl.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.tratamiento.PlanTratamientoService;
import com.saludsystem.paciente.domain.model.Tratamiento.PlanTratamientoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedidaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.tratamiento.PlanTratamientoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlanTratamientoServiceImpl extends GenericServiceImpl<PlanTratamientoEntity, PlanTratamientoDTO,
        CrearPlanTratamientoDTO, ActualizarPlanTratamientoDTO, UUID> implements PlanTratamientoService {

    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;
    private final DoctorRepository doctorRepository;
    private final MedidaRepository medidaRepository;

    public PlanTratamientoServiceImpl(
            PlanTratamientoRepository planTratamientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository,
            DoctorRepository doctorRepository, MedidaRepository medidaRepository) {
        super(planTratamientoRepository, modelMapper, authValidator, PlanTratamientoDTO.class
        );
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
    protected void updateEntityFromDto(PlanTratamientoEntity entity, ActualizarPlanTratamientoDTO dto) {
        Optional.ofNullable(dto.getPacienteId()).flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getDoctorId()).flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getEspecialidadId()).flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(dto.getMedidaId()).flatMap(medidaRepository::findById)
                .ifPresent(entity::setMedidaEntity);
        Optional.ofNullable(dto.getFechaInicio()).ifPresent(entity::setFechaInicio);
        Optional.ofNullable(dto.getFechaFin()).ifPresent(entity::setFechaFin);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPlanTratamientoDTO crearPlanTratamientoDTO) {
        return super.save(crearPlanTratamientoDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPlanTratamientoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}