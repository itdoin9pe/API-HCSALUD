package com.saludsystem.paciente.application.service.impl.historialclinico.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CrearProcedimientoDTO;
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
public class ProcedimientoServiceImpl extends GenericServiceImpl<ProcedimientoEntity, CrearProcedimientoDTO,
        ProcedimientoDTO, UUID> implements ProcedimientoService {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public ProcedimientoServiceImpl(
            ProcedimientoRepository procedimientoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        super(procedimientoRepository, modelMapper, authValidator, ProcedimientoDTO.class
        );
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
    protected void updateEntityFromDto(ProcedimientoEntity entity, CrearProcedimientoDTO dto) {
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
    public ApiResponse save(CrearProcedimientoDTO crearProcedimientoDTO) {
        return super.save(crearProcedimientoDTO);
    }

    @Override
    public ListResponse<ProcedimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearProcedimientoDTO updateDto) {
        return super.update(uuid, updateDto);
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