package com.saludsystem.application.services.configuracion.impl;

import com.saludsystem.application.dtos.configuracion.get.SedeDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearSedeDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarSedeDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.configuracion.SedeService;
import com.saludsystem.domain.model.SucursalEntity;
import com.saludsystem.domain.model.configuracion.SedeEntity;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.SucursalRepository;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SedeRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SedeServiceImpl extends GenericServiceImpl<SedeEntity, SedeDTO, UUID,
        CrearSedeDTO, ActualizarSedeDTO> implements SedeService {

    private final SucursalRepository sucursalRepository;

    public SedeServiceImpl(SedeRepository sedeRepository, ModelMapper modelMapper, AuthValidator authValidator,
                           SucursalRepository sucursalRepository) {
        super(sedeRepository, modelMapper, authValidator, SedeDTO.class,
                sedeEntity -> modelMapper.map(sedeEntity, SedeDTO.class));
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
    public ListResponse<SedeDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarSedeDTO actualizarSedeDTO) {
        return super.update(uuid, actualizarSedeDTO);
    }

    @Override
    public List<SedeDTO> getList() {
        return super.getList();
    }

    @Override
    public SedeDTO getById(UUID uuid) {
        return super.getById(uuid);
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
    protected void updateEntityFromDto(ActualizarSedeDTO actualizarSedeDTO, SedeEntity entity) {
        entity.setCodigo(actualizarSedeDTO.getCodigo());
        entity.setNombre(actualizarSedeDTO.getNombre());
        entity.setDireccion(actualizarSedeDTO.getDireccion());
        entity.setUbigeo(actualizarSedeDTO.getUbigeo());
        entity.setEstado(actualizarSedeDTO.getEstado());
    }
}