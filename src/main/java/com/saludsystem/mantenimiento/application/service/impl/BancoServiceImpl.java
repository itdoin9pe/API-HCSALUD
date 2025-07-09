package com.saludsystem.mantenimiento.application.service.impl;

import com.saludsystem.mantenimiento.application.dto.get.BancoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearBancoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarBancoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.mantenimiento.application.service.BancoService;
import com.saludsystem.mantenimiento.domain.model.BancoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.BancoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BancoServiceImpl extends GenericServiceImpl<BancoEntity, BancoDTO, CrearBancoDTO,
        ActualizarBancoDTO, UUID> implements BancoService {

    protected BancoServiceImpl(BancoRepository bancoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(bancoRepository, modelMapper, authValidator, BancoDTO.class);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearBancoDTO crearBancoDTO) {
        return super.save(crearBancoDTO);
    }

    @Override
    public ListResponse<BancoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarBancoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<BancoDTO> getList() {
        return super.getList();
    }

    @Override
    public BancoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected BancoEntity convertCreateDtoToEntity(CrearBancoDTO crearBancoDTO) {
        BancoEntity entity = new BancoEntity();
        entity.setDescripcion(crearBancoDTO.getDescripcion());
        entity.setEstado(crearBancoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(BancoEntity entity, ActualizarBancoDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}