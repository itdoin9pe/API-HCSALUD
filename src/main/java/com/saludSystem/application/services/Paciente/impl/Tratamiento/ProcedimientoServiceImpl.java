package com.saludSystem.application.services.Paciente.impl.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.ProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarProcedimientoDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.Tratamiento.ProcedimientoService;
import com.saludSystem.domain.model.Paciente.Tratamiento.ProcedimientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.Tratamiento.ProcedimientoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcedimientoServiceImpl extends GenericServiceImpl<ProcedimientoEntity, ProcedimientoDTO, UUID,
        CrearProcedimientoDTO, ActualizarProcedimientoDTO> implements ProcedimientoService {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public ProcedimientoServiceImpl(
            ProcedimientoRepository procedimientoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        super(procedimientoRepository, modelMapper, authValidator, ProcedimientoDTO.class,
                procedimientoEntity -> modelMapper.map(procedimientoEntity, ProcedimientoDTO.class));
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected ProcedimientoEntity convertCreateDtoToEntity(CrearProcedimientoDTO crearProcedimientoDTO) {
        ProcedimientoEntity entity = new ProcedimientoEntity();
        doctorRepository.findById(crearProcedimientoDTO.getDoctorId()).ifPresent(entity::setDoctorEntity);
        pacienteRepository.findById(crearProcedimientoDTO.getPacienteId()).ifPresent(entity::setPacienteEntity);
        entity.setTipoProcedimiento(crearProcedimientoDTO.getTipoProcedimiento());
        entity.setDescripcion(crearProcedimientoDTO.getDescripcion());
        entity.setFecha(crearProcedimientoDTO.getFecha());
        entity.setResultado(crearProcedimientoDTO.getResultado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarProcedimientoDTO actualizarProcedimientoDTO, ProcedimientoEntity entity) {
        Optional.ofNullable(actualizarProcedimientoDTO.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(actualizarProcedimientoDTO.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        entity.setTipoProcedimiento(actualizarProcedimientoDTO.getTipoProcedimiento());
        entity.setDescripcion(actualizarProcedimientoDTO.getDescripcion());
        entity.setFecha(actualizarProcedimientoDTO.getFecha());
        entity.setResultado(actualizarProcedimientoDTO.getResultado());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearProcedimientoDTO crearProcedimientoDTO) {
        return super.save(crearProcedimientoDTO);
    }

    @Override
    public ListResponse<ProcedimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarProcedimientoDTO actualizarProcedimientoDTO) {
        return super.update(uuid, actualizarProcedimientoDTO);
    }

    @Override
    public ProcedimientoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<ProcedimientoDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}