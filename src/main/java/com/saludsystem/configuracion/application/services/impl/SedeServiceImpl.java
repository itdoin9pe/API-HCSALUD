package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.res.SedeResponse;
import com.saludsystem.configuracion.application.dto.req.SedeRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.configuracion.application.services.SedeService;
import com.saludsystem.shared.domain.model.SucursalEntity;
import com.saludsystem.configuracion.domain.model.SedeEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SedeRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SedeServiceImpl extends GenericServiceImpl<SedeEntity, SedeRequest, SedeResponse, UUID>
        implements SedeService {

    private final SucursalRepository sucursalRepository;

    public SedeServiceImpl(SedeRepository sedeRepository, ModelMapper modelMapper, AuthValidator authValidator,
                           SucursalRepository sucursalRepository) {
        super(sedeRepository, modelMapper, authValidator, SedeResponse.class);
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(SedeRequest sedeRequest) {
        return super.save(sedeRequest);
    }

    @Override
    protected void beforeSave(SedeEntity entity, SedeRequest dto) {
        UserEntity user = authValidator.getCurrentUser();
        List<SucursalEntity> sucursales = sucursalRepository.findByHospital_HospitalId(user.getHospital().getHospitalId());
        if (sucursales.isEmpty()) {
            throw new IllegalStateException("No hay sucursales registradas para este hospital");
        }
        if (sucursales.size() > 1) {
            throw new IllegalStateException("Existen múltiples sucursales, debe especificar una");
        }
        entity.setSucursalEntity(sucursales.get(0));
    }

    @Override
    public ListResponse<SedeResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, SedeRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<SedeResponse> getList() {
        return super.getList();
    }

    @Override
    public SedeResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected SedeEntity convertCreateDtoToEntity(SedeRequest sedeRequest) {
        SedeEntity entity = new SedeEntity();
        entity.setCodigo(sedeRequest.getCodigo());
        entity.setNombre(sedeRequest.getNombre());
        entity.setDireccion(sedeRequest.getDireccion());
        entity.setUbigeo(sedeRequest.getUbigeo());
        entity.setEstado(sedeRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(SedeEntity entity, SedeRequest dto) {
        Optional.ofNullable(dto.getCodigo()).ifPresent(entity::setCodigo);
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getUbigeo()).ifPresent(entity::setUbigeo);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}