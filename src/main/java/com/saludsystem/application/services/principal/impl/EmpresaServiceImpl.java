package com.saludsystem.application.services.principal.impl;

import com.saludsystem.application.dtos.principal.get.EmpresaDTO;
import com.saludsystem.application.dtos.principal.post.CrearEmpresaDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarEmpresaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.principal.EmpresaService;
import com.saludsystem.domain.model.principal.EmpresaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.principal.EmpresaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmpresaServiceImpl extends GenericServiceImpl<EmpresaEntity, EmpresaDTO, UUID,
        CrearEmpresaDTO, ActualizarEmpresaDTO> implements EmpresaService {

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(empresaRepository, modelMapper, authValidator, EmpresaDTO.class,
                empresaEntity -> modelMapper.map(empresaEntity, EmpresaDTO.class));
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearEmpresaDTO crearEmpresaDTO) {
        return super.save(crearEmpresaDTO);
    }

    @Override
    public ListResponse<EmpresaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarEmpresaDTO actualizarEmpresaDTO) {
        return super.update(uuid, actualizarEmpresaDTO);
    }

    @Override
    public EmpresaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<EmpresaDTO> getList() {
        return super.getList();
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
    protected void updateEntityFromDto(ActualizarEmpresaDTO actualizarEmpresaDTO, EmpresaEntity entity) {
        entity.setDescripcion(actualizarEmpresaDTO.getDescripcion());
        entity.setEstado(actualizarEmpresaDTO.getEstado());
    }
}