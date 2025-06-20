package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.GET.TipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoConceptoDTO;
import com.saludSystem.application.services.Catalogo.TipoConceptoService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.TipoConceptoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.TipoConceptoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.GenericRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipoConceptoServiceImpl extends GenericServiceImpl<TipoConceptoEntity, TipoConceptoDTO, UUID,
        CrearTipoConceptoDTO, ActualizarTipoConceptoDTO> implements TipoConceptoService {

    public TipoConceptoServiceImpl(TipoConceptoRepository tipoConceptoRepository, ModelMapper modelMapper,
                                   AuthValidator authValidator) {
        super(tipoConceptoRepository, modelMapper, authValidator, TipoConceptoDTO.class,
                tipoConceptoEntity -> modelMapper.map(tipoConceptoEntity, TipoConceptoDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearTipoConceptoDTO crearTipoConceptoDTO) {
        return super.save(crearTipoConceptoDTO);
    }

    @Override
    public ListResponse<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarTipoConceptoDTO actualizarTipoConceptoDTO) {
        return super.update(uuid, actualizarTipoConceptoDTO);
    }

    @Override
    public TipoConceptoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<TipoConceptoDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected TipoConceptoEntity convertCreateDtoToEntity(CrearTipoConceptoDTO crearTipoConceptoDTO) {
        TipoConceptoEntity entity = new TipoConceptoEntity();
        entity.setNombre(crearTipoConceptoDTO.getNombre());
        entity.setEstado(crearTipoConceptoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarTipoConceptoDTO actualizarTipoConceptoDTO, TipoConceptoEntity entity) {
        entity.setNombre(actualizarTipoConceptoDTO.getNombre());
        entity.setEstado(actualizarTipoConceptoDTO.getEstado());
    }
}