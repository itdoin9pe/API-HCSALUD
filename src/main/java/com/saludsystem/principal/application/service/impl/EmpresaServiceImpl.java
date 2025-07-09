package com.saludsystem.principal.application.service.impl;

import com.saludsystem.principal.application.dto.get.EmpresaDTO;
import com.saludsystem.principal.application.dto.post.CrearEmpresaDTO;
import com.saludsystem.principal.application.dto.put.ActualizarEmpresaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.principal.application.service.EmpresaService;
import com.saludsystem.principal.domain.model.EmpresaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.EmpresaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaServiceImpl extends GenericServiceImpl<EmpresaEntity, EmpresaDTO, CrearEmpresaDTO,
        ActualizarEmpresaDTO, UUID> implements EmpresaService {

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(empresaRepository, modelMapper, authValidator, EmpresaDTO.class
        );
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearEmpresaDTO crearEmpresaDTO) {
        return super.save(crearEmpresaDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarEmpresaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected EmpresaEntity convertCreateDtoToEntity(CrearEmpresaDTO crearEmpresaDTO) {
        EmpresaEntity entity = new EmpresaEntity();
        entity.setDescripcion(crearEmpresaDTO.getDescripcion());
        entity.setEstado(crearEmpresaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(EmpresaEntity entity, ActualizarEmpresaDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}