package com.saludSystem.application.services.Principal.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Principal.EmpresaService;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarEmpresaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEmpresaDTO;
import com.saludSystem.application.dtos.Principal.GET.EmpresaDTO;
import com.saludSystem.domain.model.Principal.EmpresaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Principal.EmpresaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
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