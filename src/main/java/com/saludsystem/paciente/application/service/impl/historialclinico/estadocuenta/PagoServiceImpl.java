package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.PagoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.PagoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.PagoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstadoCuenta.PagoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.PagoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PagoServiceImpl extends GenericServiceImpl<PagoEntity, PagoRequest, PagoResponse, UUID> implements PagoService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, ModelMapper modelMapper, AuthValidator authValidator,
                           EstadoCuentaRepository estadoCuentaRepository) {
        super(pagoRepository, modelMapper, authValidator, PagoResponse.class
        );
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected PagoEntity convertCreateDtoToEntity(PagoRequest pagoRequest) {
        PagoEntity entity = new PagoEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(pagoRequest.getEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaPago(pagoRequest.getFechaPago());
        entity.setMonto(pagoRequest.getMonto());
        entity.setMetodoPago(pagoRequest.getMetodoPago());
        entity.setReferenciaPago(pagoRequest.getReferenciaPago());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(PagoEntity entity, PagoRequest dto) {
        entity.setFechaPago(dto.getFechaPago());
        entity.setMonto(dto.getMonto());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setReferenciaPago(dto.getReferenciaPago());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(PagoRequest pagoRequest) {
        return super.save(pagoRequest);
    }

    @Override
    public ListResponse<PagoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, PagoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<PagoResponse> getList() {
        return super.getList();
    }

    @Override
    public PagoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}