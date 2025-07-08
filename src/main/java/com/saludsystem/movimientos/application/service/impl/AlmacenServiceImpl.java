package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.res.AlmacenResponse;
import com.saludsystem.movimientos.application.dto.req.AlmacenRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.movimientos.application.service.AlmacenService;
import com.saludsystem.shared.domain.model.SucursalEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.movimientos.domain.model.AlmacenEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SedeRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.AlmacenRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlmacenServiceImpl extends GenericServiceImpl<AlmacenEntity, AlmacenRequest, AlmacenResponse, UUID>
        implements AlmacenService {

    private final SucursalRepository sucursalRepository;
    private final SedeRepository sedeRepository;

    public AlmacenServiceImpl(
            AlmacenRepository almacenRepository, ModelMapper modelMapper,
            AuthValidator authValidator, SucursalRepository sucursalRepository, SedeRepository sedeRepository) {
        super(almacenRepository, modelMapper, authValidator, AlmacenResponse.class);
        this.sucursalRepository = sucursalRepository;
        this.sedeRepository = sedeRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(AlmacenRequest almacenRequest) {
        return super.save(almacenRequest);
    }

    @Override
    protected void beforeSave(AlmacenEntity entity, AlmacenRequest almacenRequest) {
        UserEntity user = authValidator.getCurrentUser();
        // Buscar sede
        sedeRepository.findById(almacenRequest.getSedeId())
                .ifPresentOrElse(entity::setSedeEntity,
                        () -> { throw new RuntimeException("Sede no encontrada"); });
        // Buscar primera sucursal disponible
        SucursalEntity sucursal = sucursalRepository.findFirstByOrderBySucursalIdAsc()
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        entity.setSucursalEntity(sucursal);
    }

    @Override
    public ListResponse<AlmacenResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, AlmacenRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public AlmacenResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<AlmacenResponse> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected AlmacenEntity convertCreateDtoToEntity(AlmacenRequest almacenRequest) {
        AlmacenEntity entity = new AlmacenEntity();
        entity.setNombre(almacenRequest.getNombre());
        entity.setEstado(almacenRequest.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AlmacenEntity entity, AlmacenRequest dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}