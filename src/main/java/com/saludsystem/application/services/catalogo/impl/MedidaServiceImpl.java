package com.saludsystem.application.services.catalogo.impl;

import com.saludsystem.application.dtos.catalogo.req.MedidaDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearMedidaDTO;
import com.saludsystem.application.services.catalogo.MedidaService;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.domain.model.catalogo.MedidaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.MedidaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedidaServiceImpl extends GenericServiceImpl<MedidaEntity, CrearMedidaDTO, MedidaDTO, UUID>
        implements MedidaService {


    protected MedidaServiceImpl(MedidaRepository medidaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(medidaRepository, modelMapper, authValidator, MedidaDTO.class);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearMedidaDTO crearMedidaDTO) {
        return super.save(crearMedidaDTO);
    }

    @Override
    public ListResponse<MedidaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, CrearMedidaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public MedidaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<MedidaDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected MedidaEntity convertCreateDtoToEntity(CrearMedidaDTO crearMedidaDTO) {
        MedidaEntity entity = new MedidaEntity();
        entity.setNombre(crearMedidaDTO.getNombre());
        entity.setEstado(crearMedidaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MedidaEntity entity, CrearMedidaDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}