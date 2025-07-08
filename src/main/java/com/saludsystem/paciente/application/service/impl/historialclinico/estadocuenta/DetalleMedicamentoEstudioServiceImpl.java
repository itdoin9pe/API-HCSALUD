package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.DetalleMedicamentoEstudioResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.DetalleMedicamentoEstudioRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.DetalleMedicamentoEstudioService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstadoCuenta.DetalleMedicamentosEstudiosEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.DetalleMedicamentoEstudioRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DetalleMedicamentoEstudioServiceImpl extends GenericServiceImpl<DetalleMedicamentosEstudiosEntity,
        DetalleMedicamentoEstudioRequest, DetalleMedicamentoEstudioResponse, UUID>
        implements DetalleMedicamentoEstudioService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public DetalleMedicamentoEstudioServiceImpl(
            DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(detalleMedicamentoEstudioRepository, modelMapper, authValidator, DetalleMedicamentoEstudioResponse.class);
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected DetalleMedicamentosEstudiosEntity convertCreateDtoToEntity(DetalleMedicamentoEstudioRequest detalleMedicamentoEstudioRequest) {
        DetalleMedicamentosEstudiosEntity entity = new DetalleMedicamentosEstudiosEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(detalleMedicamentoEstudioRequest.getEstadoCuentaId())
                .orElseThrow(() -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setTipo(detalleMedicamentoEstudioRequest.getTipo());
        entity.setDescripcion(detalleMedicamentoEstudioRequest.getDescripcion());
        entity.setCantidad(detalleMedicamentoEstudioRequest.getCantidad());
        entity.setCostoUnitario(detalleMedicamentoEstudioRequest.getCostoUnitario());
        entity.setTotalCosto(detalleMedicamentoEstudioRequest.getTotalCosto());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(DetalleMedicamentosEstudiosEntity entity, DetalleMedicamentoEstudioRequest dto) {
        entity.setTipo(dto.getTipo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCantidad(dto.getCantidad());
        entity.setCostoUnitario(dto.getCostoUnitario());
        entity.setTotalCosto(dto.getTotalCosto());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(DetalleMedicamentoEstudioRequest detalleMedicamentoEstudioRequest) {
        return super.save(detalleMedicamentoEstudioRequest);
    }

    @Override
    public ListResponse<DetalleMedicamentoEstudioResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, DetalleMedicamentoEstudioRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public DetalleMedicamentoEstudioResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<DetalleMedicamentoEstudioResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}