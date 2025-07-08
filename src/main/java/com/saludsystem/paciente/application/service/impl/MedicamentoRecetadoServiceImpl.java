package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoResponse;
import com.saludsystem.paciente.application.dto.req.MedicamentoRecetadoRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.MedicamentoRecetadoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.catalogo.domain.model.MedicamentoEntity;
import com.saludsystem.paciente.domain.model.MedicamentoRecetadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedicamentoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.MedicamentoRecetadoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoRecetadoServiceImpl extends GenericServiceImpl<MedicamentoRecetadoEntity,
        MedicamentoRecetadoRequest, MedicamentoRecetadoResponse, UUID> implements MedicamentoRecetadoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoRecetadoServiceImpl(
            MedicamentoRecetadoRepository medicamentoRecetadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, MedicamentoRepository medicamentoRepository) {
        super(medicamentoRecetadoRepository, modelMapper, authValidator, MedicamentoRecetadoResponse.class
        );
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    protected MedicamentoRecetadoEntity convertCreateDtoToEntity(MedicamentoRecetadoRequest medicamentoRecetadoRequest) {
        MedicamentoRecetadoEntity entity = new MedicamentoRecetadoEntity();
        MedicamentoEntity medicamento = medicamentoRepository.findById(medicamentoRecetadoRequest.getMedicamentoId())
                .orElseThrow( () -> new ResourceNotFoundException("Medicamento not found"));
        entity.setDosis(medicamentoRecetadoRequest.getDosis());
        entity.setFrecuencia(medicamentoRecetadoRequest.getFrecuencia());
        entity.setIndicaciones(medicamentoRecetadoRequest.getIndicaciones());
        entity.setDuracionDias(medicamentoRecetadoRequest.getDuracionDias());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MedicamentoRecetadoEntity entity, MedicamentoRecetadoRequest dto) {
        Optional.ofNullable(dto.getMedicamentoId()).flatMap(medicamentoRepository::findById).
                ifPresent(entity::setMedicamentoEntity);
        entity.setDosis(dto.getDosis());
        entity.setFrecuencia(dto.getFrecuencia());
        entity.setIndicaciones(dto.getIndicaciones());
        entity.setDuracionDias(dto.getDuracionDias());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(MedicamentoRecetadoRequest medicamentoRecetadoRequest) {
        return super.save(medicamentoRecetadoRequest);
    }

    @Override
    public ListResponse<MedicamentoRecetadoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, MedicamentoRecetadoRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<MedicamentoRecetadoResponse> getList() {
        return super.getList();
    }

    @Override
    public MedicamentoRecetadoResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}