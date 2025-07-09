package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.DetalleMedicamentoEstudioService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.estadocuenta.DetalleMedicamentosEstudiosEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta.DetalleMedicamentoEstudioRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.estadocuenta.EstadoCuentaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DetalleMedicamentoEstudioServiceImpl extends GenericServiceImpl<DetalleMedicamentosEstudiosEntity,
        DetalleMedicamentoEstudioDTO, CrearDetalleMedicamentoEstudioDTO, ActualizarDetalleMedicamentoEstudioDTO, UUID>
        implements DetalleMedicamentoEstudioService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public DetalleMedicamentoEstudioServiceImpl(
            DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(detalleMedicamentoEstudioRepository, modelMapper, authValidator, DetalleMedicamentoEstudioDTO.class);
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
    protected void updateEntityFromDto(DetalleMedicamentosEstudiosEntity entity, ActualizarDetalleMedicamentoEstudioDTO dto) {
        entity.setTipo(dto.getTipo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setCantidad(dto.getCantidad());
        entity.setCostoUnitario(dto.getCostoUnitario());
        entity.setTotalCosto(dto.getTotalCosto());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        return super.save(crearDetalleMedicamentoEstudioDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarDetalleMedicamentoEstudioDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}