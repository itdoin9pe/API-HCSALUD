package com.saludsystem.paciente.application.service.impl.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.CostoHospitalizacionResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta.CostoHospitalizacionRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.estadocuenta.CostoHospitalizacionService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.CostoHospitalizacionRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CostoHospitalizacionServiceImpl extends GenericServiceImpl<CostoHospitalizacionEntity,
        CostoHospitalizacionRequest, CostoHospitalizacionResponse, UUID> implements CostoHospitalizacionService {

    private final EstadoCuentaRepository estadoCuentaRepository;

    public CostoHospitalizacionServiceImpl(
            CostoHospitalizacionRepository costoHospitalizacionRepository,
            ModelMapper modelMapper, AuthValidator authValidator, EstadoCuentaRepository estadoCuentaRepository) {
        super(costoHospitalizacionRepository, modelMapper, authValidator, CostoHospitalizacionResponse.class
        );
        this.estadoCuentaRepository = estadoCuentaRepository;
    }

    @Override
    protected CostoHospitalizacionEntity convertCreateDtoToEntity(CostoHospitalizacionRequest costoHospitalizacionRequest) {
        CostoHospitalizacionEntity entity = new CostoHospitalizacionEntity();
        entity.setEstadoCuentaEntity(estadoCuentaRepository.findById(costoHospitalizacionRequest.getPacEstadoCuentaId())
                .orElseThrow( () -> new ResourceNotFoundException("Estado de cuenta not found")));
        entity.setFechaIngreso(costoHospitalizacionRequest.getFechaIngreso());
        entity.setFechaAlta(costoHospitalizacionRequest.getFechaAlta());
        entity.setTipoHabitacion(costoHospitalizacionRequest.getTipoHabitacion());
        entity.setCostoPorDia(costoHospitalizacionRequest.getCostoPorDia());
        entity.setCantidadDias(costoHospitalizacionRequest.getCantidadDias());
        entity.setTotalCosto(costoHospitalizacionRequest.getTotalCosto());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(CostoHospitalizacionEntity entity, CostoHospitalizacionRequest dto) {
        Optional.ofNullable(dto.getFechaIngreso()).ifPresent(entity::setFechaIngreso);
        Optional.ofNullable(dto.getFechaAlta()).ifPresent(entity::setFechaIngreso);
        Optional.ofNullable(dto.getTipoHabitacion()).ifPresent(entity::setTipoHabitacion);
        Optional.ofNullable(dto.getCostoPorDia()).ifPresent(entity::setCostoPorDia);
        Optional.ofNullable(dto.getCantidadDias()).ifPresent(entity::setCantidadDias);
        Optional.ofNullable(dto.getTotalCosto()).ifPresent(entity::setTotalCosto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CostoHospitalizacionRequest costoHospitalizacionRequest) {
        return super.save(costoHospitalizacionRequest);
    }

    @Override
    public ListResponse<CostoHospitalizacionResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CostoHospitalizacionRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public CostoHospitalizacionResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CostoHospitalizacionResponse> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}