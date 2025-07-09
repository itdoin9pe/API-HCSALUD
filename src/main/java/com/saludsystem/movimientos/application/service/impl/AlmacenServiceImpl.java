package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.post.CrearAlmacenDTO;
import com.saludsystem.movimientos.application.dto.get.AlmacenDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarAlmacenDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.movimientos.application.service.AlmacenService;
import com.saludsystem.shared.domain.model.SucursalEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.movimientos.domain.model.AlmacenEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SedeRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.AlmacenRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AlmacenServiceImpl extends GenericServiceImpl<AlmacenEntity, AlmacenDTO, CrearAlmacenDTO,
        ActualizarAlmacenDTO, UUID> implements AlmacenService {

    private final SucursalRepository sucursalRepository;
    private final SedeRepository sedeRepository;

    public AlmacenServiceImpl(
            AlmacenRepository almacenRepository, ModelMapper modelMapper,
            AuthValidator authValidator, SucursalRepository sucursalRepository, SedeRepository sedeRepository) {
        super(almacenRepository, modelMapper, authValidator, AlmacenDTO.class);
        this.sucursalRepository = sucursalRepository;
        this.sedeRepository = sedeRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearAlmacenDTO almacenDTO) {
        return super.save(almacenDTO);
    }

    @Override
    protected void beforeSave(AlmacenEntity entity, CrearAlmacenDTO almacenDTO) {
        UserEntity user = authValidator.getCurrentUser();
        // Buscar sede
        sedeRepository.findById(almacenDTO.getSedeId())
                .ifPresentOrElse(entity::setSedeEntity,
                        () -> { throw new RuntimeException("Sede no encontrada"); });
        // Buscar primera sucursal disponible
        SucursalEntity sucursal = sucursalRepository.findFirstByOrderBySucursalIdAsc()
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        entity.setSucursalEntity(sucursal);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarAlmacenDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected AlmacenEntity convertCreateDtoToEntity(CrearAlmacenDTO almacenDTO) {
        AlmacenEntity entity = new AlmacenEntity();
        entity.setNombre(almacenDTO.getNombre());
        entity.setEstado(almacenDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AlmacenEntity entity, ActualizarAlmacenDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}