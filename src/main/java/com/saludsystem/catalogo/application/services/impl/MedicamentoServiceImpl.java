package com.saludsystem.catalogo.application.services.impl;

import com.saludsystem.catalogo.application.dtos.res.MedicamentoDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearMedicamentoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.catalogo.application.services.MedicamentoService;
import com.saludsystem.catalogo.domain.model.MedicamentoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedicamentoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoServiceImpl extends GenericServiceImpl<MedicamentoEntity, CrearMedicamentoDTO,
        MedicamentoDTO, UUID> implements MedicamentoService {

    protected MedicamentoServiceImpl(
            MedicamentoRepository medicamentoRepository,
            ModelMapper modelMapper, AuthValidator authValidator) {
        super(medicamentoRepository, modelMapper, authValidator, MedicamentoDTO.class);
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
    public ApiResponse update(UUID uuid, CrearMedicamentoDTO updateDto) {
        return super.update(uuid, updateDto);
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
    protected void updateEntityFromDto(MedicamentoEntity entity, CrearMedicamentoDTO dto) {
        Optional.ofNullable(dto.getNombre()).ifPresent(entity::setNombre);
        Optional.ofNullable(dto.getFormaFarmaceutica()).ifPresent(entity::setFormaFarmaceutica);
        Optional.ofNullable(dto.getConcentracion()).ifPresent(entity::setConcentracion);
        Optional.ofNullable(dto.getContenido()).ifPresent(entity::setContenido);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }
}