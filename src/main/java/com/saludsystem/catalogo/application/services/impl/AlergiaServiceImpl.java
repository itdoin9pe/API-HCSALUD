package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.AlergiaDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearAlergiaDTO;
import com.saludsystem.catalogo.application.services.AlergiaService;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.domain.model.AlergiaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.AlergiaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlergiaServiceImpl extends GenericServiceImpl<AlergiaEntity,
        CrearAlergiaDTO, AlergiaDTO, UUID> implements AlergiaService {

    protected AlergiaServiceImpl(
            AlergiaRepository alergiaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(alergiaRepository, modelMapper, authValidator, AlergiaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearAlergiaDTO dto) {
        return super.save(dto);
    }

    @Override
    public ListResponse<AlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearAlergiaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public AlergiaDTO getById(UUID id) {
        return super.getById(id);
    }

    @Override
    public List<AlergiaDTO> getList() {
        return super.getList();
    }

    @Override
    protected AlergiaEntity convertCreateDtoToEntity(CrearAlergiaDTO crearAlergiaDTO) {
        AlergiaEntity entity = new AlergiaEntity();
        entity.setNombre(crearAlergiaDTO.getNombre());
        entity.setEstado(crearAlergiaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AlergiaEntity entity, CrearAlergiaDTO dto) {
        Optional.ofNullable(dto.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}