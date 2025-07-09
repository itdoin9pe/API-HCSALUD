package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.get.EspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarEspecialidadDTO;
import com.saludsystem.catalogo.application.services.EspecialidadService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.EspecialidadEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<EspecialidadEntity, EspecialidadDTO,
        CrearEspecialidadDTO, ActualizarEspecialidadDTO, UUID> implements EspecialidadService {

    protected EspecialidadServiceImpl(
            EspecialidadRepository especialidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(especialidadRepository, modelMapper, authValidator, EspecialidadDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearEspecialidadDTO especialidadDTO) {
        return super.save(especialidadDTO);
    }

    @Override
    public ListResponse<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarEspecialidadDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    public EspecialidadDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EspecialidadDTO> getList() {
        return super.getList();
    }

    @Override
    protected EspecialidadEntity convertCreateDtoToEntity(CrearEspecialidadDTO especialidadDTO) {
        EspecialidadEntity entity = new EspecialidadEntity();
        entity.setNombre(especialidadDTO.getNombre());
        entity.setDescripcion(especialidadDTO.getDescripcion());
        entity.setEstado(especialidadDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EspecialidadEntity entity, ActualizarEspecialidadDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}