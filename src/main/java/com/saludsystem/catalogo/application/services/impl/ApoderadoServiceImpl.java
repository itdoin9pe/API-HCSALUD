package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.ApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearApoderadoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.ApoderadoService;
import com.saludsystem.catalogo.domain.model.ApoderadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.ApoderadoRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApoderadoServiceImpl extends GenericServiceImpl<ApoderadoEntity, CrearApoderadoDTO,
        ApoderadoDTO, UUID> implements ApoderadoService {

    private final SysSaludRepository sysSaludRepository;

    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, SysSaludRepository sysSaludRepository) {
        super(apoderadoRepository, modelMapper, authValidator, ApoderadoDTO.class);
        this.sysSaludRepository = sysSaludRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearApoderadoDTO dto) {
        return super.save(dto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearApoderadoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public ApoderadoDTO getById(UUID id) {
        return super.getById(id);
    }

    @Override
    public List<ApoderadoDTO> getList() {
        return super.getList();
    }
    
    @Override
    public ListResponse<ApoderadoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    protected ApoderadoEntity convertCreateDtoToEntity(CrearApoderadoDTO crearApoderadoDTO) {
        ApoderadoEntity entity = new ApoderadoEntity();
        entity.setNombre(crearApoderadoDTO.getNombre());
        entity.setNroDocumento(crearApoderadoDTO.getNroDocumento());
        entity.setDireccion(crearApoderadoDTO.getDireccion());
        entity.setTelefono(crearApoderadoDTO.getTelefono());
        entity.setEstado(crearApoderadoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ApoderadoEntity entity, CrearApoderadoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getNroDocumento()).ifPresent(entity::setNroDocumento);
        Optional.ofNullable(dto.getDireccion()).ifPresent(entity::setDireccion);
        Optional.ofNullable(dto.getTelefono()).ifPresent(entity::setTelefono);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}