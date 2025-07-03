package com.saludsystem.application.services.catalogo.impl;


import com.saludsystem.application.dtos.catalogo.get.MedicamentoDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearMedicamentoDTO;
import com.saludsystem.application.dtos.catalogo.put.ActualizarMedicamentoDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.catalogo.MedicamentoService;
import com.saludsystem.domain.model.catalogo.MedicamentoEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.MedicamentoRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MedicamentoServiceImpl extends GenericServiceImpl<MedicamentoEntity, MedicamentoDTO, UUID,
        CrearMedicamentoDTO, ActualizarMedicamentoDTO> implements MedicamentoService {

    public MedicamentoServiceImpl(MedicamentoRepository repository,
                                  ModelMapper modelMapper, AuthValidator authValidator) {
        super(repository, modelMapper, authValidator, MedicamentoDTO.class,
                entity -> modelMapper.map(entity, MedicamentoDTO.class)
        );
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse save(CrearMedicamentoDTO crearMedicamentoDTO) {
        return super.save(crearMedicamentoDTO);
    }

    @Override
    public ListResponse<MedicamentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse update(UUID uuid, ActualizarMedicamentoDTO actualizarMedicamentoDTO) {
        return super.update(uuid, actualizarMedicamentoDTO);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ApiResponse delete(UUID id) {
        return super.delete(id);
    }

    @Override
    public MedicamentoDTO getById(UUID id) {
        return super.getById(id);
    }

    @Override
    protected MedicamentoEntity convertCreateDtoToEntity(CrearMedicamentoDTO dto) {
        MedicamentoEntity entity = new MedicamentoEntity();
        entity.setNombre(dto.getNombre());
        entity.setFormaFarmaceutica(dto.getFormaFarmaceutica());
        entity.setConcentracion(dto.getConcentracion());
        entity.setContenido(dto.getContenido());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarMedicamentoDTO dto, MedicamentoEntity entity) {
        entity.setNombre(dto.getNombre());
        entity.setContenido(dto.getContenido());
        entity.setConcentracion(dto.getConcentracion());
        entity.setFormaFarmaceutica(dto.getFormaFarmaceutica());
        entity.setEstado(dto.getEstado());
    }
}