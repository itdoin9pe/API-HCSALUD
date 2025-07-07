package com.saludsystem.application.services.principal.impl;

import com.saludsystem.application.dtos.principal.res.EmpresaDTO;
import com.saludsystem.application.dtos.principal.req.CrearEmpresaDTO;
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
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaServiceImpl extends GenericServiceImpl<EmpresaEntity, CrearEmpresaDTO, EmpresaDTO, UUID>
        implements EmpresaService {

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(empresaRepository, modelMapper, authValidator, EmpresaDTO.class
        );
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
    public ApiResponse update(UUID uuid, CrearEmpresaDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(EmpresaEntity entity, CrearEmpresaDTO dto) {
        Optional.ofNullable(dto.getDescripcion()).ifPresent(entity::setDescripcion);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}