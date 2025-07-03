package com.saludsystem.application.services.mantenimiento.impl;

import com.saludsystem.application.dtos.mantenimiento.get.BancoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearBancoDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarBancoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.mantenimiento.BancoService;
import com.saludsystem.domain.model.mantenimiento.BancoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.mantenimiento.BancoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BancoServiceImpl extends GenericServiceImpl<
        BancoEntity, BancoDTO, UUID, CrearBancoDTO, ActualizarBancoDTO> implements BancoService {

    public BancoServiceImpl(BancoRepository bancoRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(bancoRepository, modelMapper, authValidator, BancoDTO.class,
                bancoEntity -> modelMapper.map(bancoEntity, BancoDTO.class));
    }

    @Override
    public ApiResponse save(CrearBancoDTO crearBancoDTO) {
        return super.save(crearBancoDTO);
    }

    @Override
    public ListResponse<BancoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    public ApiResponse update(UUID uuid, ActualizarBancoDTO actualizarBancoDTO) {
        return super.update(uuid, actualizarBancoDTO);
    }

    @Override
    public List<BancoDTO> getList() {
        return super.getList();
    }

    @Override
    public BancoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

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
    protected void updateEntityFromDto(ActualizarBancoDTO actualizarBancoDTO, BancoEntity entity) {
        entity.setDescripcion(actualizarBancoDTO.getDescripcion());
        entity.setEstado(actualizarBancoDTO.getEstado());
    }
}