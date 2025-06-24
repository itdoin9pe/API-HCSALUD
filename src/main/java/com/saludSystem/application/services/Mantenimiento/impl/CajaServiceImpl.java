package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Mantenimiento.CajaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCajaDTO;
import com.saludSystem.domain.model.Mantenimiento.CajaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.CajaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CajaServiceImpl extends GenericServiceImpl<CajaEntity, CajaDTO, UUID, CrearCajaDTO, ActualizarCajaDTO>
        implements CajaService {

    public CajaServiceImpl(CajaRepository cajaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(cajaRepository, modelMapper, authValidator, CajaDTO.class,
                cajaEntity -> modelMapper.map(cajaEntity, CajaDTO.class));
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearCajaDTO crearCajaDTO) {
        return super.save(crearCajaDTO);
    }

    @Override
    public ListResponse<CajaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarCajaDTO actualizarCajaDTO) {
        return super.update(uuid, actualizarCajaDTO);
    }

    @Override
    public CajaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CajaDTO> getList() {
        return super.getList();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }

    @Override
    protected CajaEntity convertCreateDtoToEntity(CrearCajaDTO crearCajaDTO) {
        CajaEntity entity = new CajaEntity();
        entity.setNombre(crearCajaDTO.getNombre());
        entity.setEstado(crearCajaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarCajaDTO actualizarCajaDTO, CajaEntity entity) {
        entity.setNombre(actualizarCajaDTO.getNombre());
        entity.setEstado(actualizarCajaDTO.getEstado());
    }
}