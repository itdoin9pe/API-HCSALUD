package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Operaciones.MarcaService;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;
import com.saludSystem.domain.model.Operaciones.MarcaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.MarcaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MarcaServiceImpl extends GenericServiceImpl<MarcaEntity, MarcaDTO, UUID,
        CrearMarcaDTO, ActualizarMarcaDTO> implements MarcaService {

    public MarcaServiceImpl(MarcaRepository marcaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(marcaRepository, modelMapper, authValidator, MarcaDTO.class,
                marcaEntity -> modelMapper.map(marcaEntity, MarcaDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearMarcaDTO crearMarcaDTO) {
        return super.save(crearMarcaDTO);
    }

    @Override
    public ListResponse<MarcaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarMarcaDTO actualizarMarcaDTO) {
        return super.update(uuid, actualizarMarcaDTO);
    }

    @Override
    public List<MarcaDTO> getList() {
        return super.getList();
    }

    @Override
    public MarcaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MarcaEntity convertCreateDtoToEntity(CrearMarcaDTO crearMarcaDTO) {
        MarcaEntity entity = new MarcaEntity();
        entity.setNombre(crearMarcaDTO.getNombre());
        entity.setEstado(crearMarcaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarMarcaDTO actualizarMarcaDTO, MarcaEntity entity) {
        entity.setNombre(actualizarMarcaDTO.getNombre());
        entity.setEstado(actualizarMarcaDTO.getEstado());
    }
}