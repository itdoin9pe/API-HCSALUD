package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.GET.MedidaDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedidaDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedidaDTO;
import com.saludSystem.application.services.Catalogo.MedidaService;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.Catalogo.MedidaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedidaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedidaServiceImpl extends GenericServiceImpl<MedidaEntity, MedidaDTO, UUID,
        CrearMedidaDTO, ActualizarMedidaDTO> implements MedidaService {

    public MedidaServiceImpl(MedidaRepository medidaRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        super(medidaRepository, modelMapper, authValidator, MedidaDTO.class,
                medidaEntity -> modelMapper.map(medidaEntity, MedidaDTO.class));
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
    public ApiResponse update(UUID uuid, ActualizarMedidaDTO actualizarMedidaDTO) {
        return super.update(uuid, actualizarMedidaDTO);
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
    protected void updateEntityFromDto(ActualizarMedidaDTO actualizarMedidaDTO, MedidaEntity entity) {
        entity.setNombre(actualizarMedidaDTO.getNombre());
        entity.setEstado(actualizarMedidaDTO.getEstado());
    }
}