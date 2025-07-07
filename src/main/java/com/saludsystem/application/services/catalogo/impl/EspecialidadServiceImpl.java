package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.post.CrearEspecialidadDTO;
import com.saludsystem.application.dtos.catalogo.req.EspecialidadDTO;
import com.saludsystem.application.services.catalogo.EspecialidadService;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.domain.model.catalogo.EspecialidadEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.EspecialidadRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<EspecialidadEntity, CrearEspecialidadDTO,
        EspecialidadDTO, UUID> implements EspecialidadService {

    protected EspecialidadServiceImpl(
            EspecialidadRepository especialidadRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(especialidadRepository, modelMapper, authValidator, EspecialidadDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearEspecialidadDTO crearEspecialidadDTO) {
        return super.save(crearEspecialidadDTO);
    }

    @Override
    public ListResponse<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearEspecialidadDTO updateDto) {
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
    protected EspecialidadEntity convertCreateDtoToEntity(CrearEspecialidadDTO crearEspecialidadDTO) {
        EspecialidadEntity entity = new EspecialidadEntity();
        entity.setNombre(crearEspecialidadDTO.getNombre());
        entity.setDescripcion(crearEspecialidadDTO.getDescripcion());
        entity.setEstado(crearEspecialidadDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EspecialidadEntity entity, CrearEspecialidadDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}