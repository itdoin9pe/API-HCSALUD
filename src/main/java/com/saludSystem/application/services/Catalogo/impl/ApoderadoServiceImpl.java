package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearApoderadoDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.ApoderadoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ApoderadoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApoderadoServiceImpl extends GenericServiceImpl<ApoderadoEntity, ApoderadoDTO,
        UUID, CrearApoderadoDTO, ActualizarApoderadoDTO> {

    private final SysSaludRepository sysSaludRepository;

    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, SysSaludRepository sysSaludRepository) {
        super(apoderadoRepository, modelMapper, authValidator, ApoderadoDTO.class,
                apoderadoEntity -> modelMapper.map(apoderadoEntity, ApoderadoDTO.class));
        this.sysSaludRepository = sysSaludRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearApoderadoDTO dto) {
        return super.save(dto);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID id, ActualizarApoderadoDTO dto) {
        return super.update(id, dto);
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
    protected void updateEntityFromDto(ActualizarApoderadoDTO actualizarApoderadoDTO, ApoderadoEntity entity) {
        entity.setNombre(actualizarApoderadoDTO.getNombre());
        entity.setNroDocumento(actualizarApoderadoDTO.getNroDocumento());
        entity.setDireccion(actualizarApoderadoDTO.getDireccion());
        entity.setTelefono(actualizarApoderadoDTO.getTelefono());
        entity.setEstado(actualizarApoderadoDTO.getEstado());
    }
}