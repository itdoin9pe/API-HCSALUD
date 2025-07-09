package com.saludsystem.configuracion.application.services.impl;

import com.saludsystem.configuracion.application.dto.get.SedeDTO;
import com.saludsystem.configuracion.application.dto.post.CrearSedeDTO;
import com.saludsystem.configuracion.application.dto.put.ActualizarSedeDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.configuracion.application.services.SedeService;
import com.saludsystem.shared.domain.model.SucursalEntity;
import com.saludsystem.configuracion.domain.model.SedeEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.shared.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SedeRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SedeServiceImpl extends GenericServiceImpl<SedeEntity, SedeDTO, CrearSedeDTO,
        ActualizarSedeDTO, UUID> implements SedeService {

    private final SucursalRepository sucursalRepository;

    public SedeServiceImpl(SedeRepository sedeRepository, ModelMapper modelMapper, AuthValidator authValidator,
                           SucursalRepository sucursalRepository) {
        super(sedeRepository, modelMapper, authValidator, SedeDTO.class);
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearSedeDTO crearSedeDTO) {
        return super.save(crearSedeDTO);
    }

    @Override
    protected void beforeSave(SedeEntity entity, CrearSedeDTO dto) {
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
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarSedeDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected SedeEntity convertCreateDtoToEntity(CrearSedeDTO crearSedeDTO) {
        SedeEntity entity = new SedeEntity();
        entity.setCodigo(crearSedeDTO.getCodigo());
        entity.setNombre(crearSedeDTO.getNombre());
        entity.setDireccion(crearSedeDTO.getDireccion());
        entity.setUbigeo(crearSedeDTO.getUbigeo());
        entity.setEstado(crearSedeDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(SedeEntity entity, ActualizarSedeDTO dto) {
        Optional.ofNullable(dto.getCodigo()).ifPresent(entity::setCodigo);
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getUbigeo()).ifPresent(entity::setUbigeo);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}