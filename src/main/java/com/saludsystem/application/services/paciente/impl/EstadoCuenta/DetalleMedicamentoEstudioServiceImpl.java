package com.saludsystem.application.services.paciente.impl.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.EstadoCuenta.DetalleMedicamentoEstudioService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.EstadoCuenta.DetalleMedicamentosEstudiosEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.DetalleMedicamentoEstudioRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DetalleMedicamentoEstudioServiceImpl extends GenericServiceImpl<DetalleMedicamentosEstudiosEntity,
        DetalleMedicamentoEstudioDTO, UUID, CrearDetalleMedicamentoEstudioDTO, ActualizarDetalleMedicamentoEstudioDTO>
        implements DetalleMedicamentoEstudioService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public DetalleMedicamentoEstudioServiceImpl(
            DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(detalleMedicamentoEstudioRepository, modelMapper, authValidator, DetalleMedicamentoEstudioDTO.class,
                detalleMedicamentosEstudiosEntity ->
                        modelMapper.map(detalleMedicamentosEstudiosEntity, DetalleMedicamentoEstudioDTO.class));
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected DetalleMedicamentosEstudiosEntity convertCreateDtoToEntity(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        DetalleMedicamentosEstudiosEntity entity = new DetalleMedicamentosEstudiosEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(crearDetalleMedicamentoEstudioDTO.getEstadoCuentaId())
                .orElseThrow(() -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setTipo(crearDetalleMedicamentoEstudioDTO.getTipo());
        entity.setDescripcion(crearDetalleMedicamentoEstudioDTO.getDescripcion());
        entity.setCantidad(crearDetalleMedicamentoEstudioDTO.getCantidad());
        entity.setCostoUnitario(crearDetalleMedicamentoEstudioDTO.getCostoUnitario());
        entity.setTotalCosto(crearDetalleMedicamentoEstudioDTO.getTotalCosto());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarDetalleMedicamentoEstudioDTO actualizarDetalleMedicamentoEstudioDTO, DetalleMedicamentosEstudiosEntity entity) {
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(actualizarDetalleMedicamentoEstudioDTO.getPacEstadoCuentaId())
                .orElseThrow(() -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setTipo(actualizarDetalleMedicamentoEstudioDTO.getTipo());
        entity.setDescripcion(actualizarDetalleMedicamentoEstudioDTO.getDescripcion());
        entity.setCantidad(actualizarDetalleMedicamentoEstudioDTO.getCantidad());
        entity.setCostoUnitario(actualizarDetalleMedicamentoEstudioDTO.getCostoUnitario());
        entity.setTotalCosto(actualizarDetalleMedicamentoEstudioDTO.getTotalCosto());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        return super.save(crearDetalleMedicamentoEstudioDTO);
    }

    @Override
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarDetalleMedicamentoEstudioDTO actualizarDetalleMedicamentoEstudioDTO) {
        return super.update(uuid, actualizarDetalleMedicamentoEstudioDTO);
    }

    @Override
    public DetalleMedicamentoEstudioDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<DetalleMedicamentoEstudioDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}