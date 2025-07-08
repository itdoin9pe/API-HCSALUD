package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.EstadoCuentaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.EstadoCuentaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.EstadoCuentaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstadoCuenta.EstadoCuentaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstadoCuentaServiceImpl extends GenericServiceImpl<EstadoCuentaEntity, EstadoCuentaRequest,
        EstadoCuentaResponse, UUID> implements EstadoCuentaService {

    private final PacienteRepository pacienteRepository;

    public EstadoCuentaServiceImpl(
            EstadoCuentaRepository estadoCuentaRepository, ModelMapper modelMapper,
            AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(estadoCuentaRepository, modelMapper, authValidator, EstadoCuentaResponse.class
        );
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected EstadoCuentaEntity convertCreateDtoToEntity(EstadoCuentaRequest estadoCuentaRequest) {
        EstadoCuentaEntity entity = new EstadoCuentaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(estadoCuentaRequest.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found") ));
        entity.setFechaApertura(estadoCuentaRequest.getFechaApertura());
        entity.setEstado(estadoCuentaRequest.getEstado());
        entity.setTotalHospitalizacion(estadoCuentaRequest.getTotalHospitalizacion());
        entity.setTotalMedicamentosEstudios(estadoCuentaRequest.getTotalMedicamentosEstudios());
        entity.setTotalPagado(estadoCuentaRequest.getTotalPagado());
        entity.setSaldoPendiente(estadoCuentaRequest.getSaldoPendiente());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EstadoCuentaEntity entity, EstadoCuentaRequest dto) {
        entity.setPacienteEntity(pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Paciente not found") ));
        entity.setFechaApertura(dto.getFechaApertura());
        entity.setEstado(dto.getEstado());
        entity.setTotalHospitalizacion(dto.getTotalHospitalizacion());
        entity.setTotalMedicamentosEstudios(dto.getTotalMedicamentosEstudios());
        entity.setTotalPagado(dto.getTotalPagado());
        entity.setSaldoPendiente(dto.getSaldoPendiente());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(EstadoCuentaRequest estadoCuentaRequest) {
        return super.save(estadoCuentaRequest);
    }

    @Override
    public ListResponse<EstadoCuentaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, EstadoCuentaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public EstadoCuentaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EstadoCuentaResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}