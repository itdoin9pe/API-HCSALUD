package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.get.MedicamentoRecetadoDTO;
import com.saludsystem.paciente.application.dto.post.CrearMedicamentoRecetadoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarMedicamentoRecetadoDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.MedicamentoRecetadoService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.MedicamentoRecetadoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedicamentoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.MedicamentoRecetadoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoRecetadoServiceImpl extends GenericServiceImpl<MedicamentoRecetadoEntity, MedicamentoRecetadoDTO,
        CrearMedicamentoRecetadoDTO, ActualizarMedicamentoRecetadoDTO, UUID> implements MedicamentoRecetadoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoRecetadoServiceImpl(
            MedicamentoRecetadoRepository medicamentoRecetadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, MedicamentoRepository medicamentoRepository) {
        super(medicamentoRecetadoRepository, modelMapper, authValidator, MedicamentoRecetadoDTO.class
        );
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    protected MedicamentoRecetadoEntity convertCreateDtoToEntity(CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO) {
        MedicamentoRecetadoEntity entity = new MedicamentoRecetadoEntity();
        medicamentoRepository.findById(crearMedicamentoRecetadoDTO.getMedicamentoId())
                .orElseThrow( () -> new ResourceNotFoundException("Medicamento not found"));
        entity.setDosis(crearMedicamentoRecetadoDTO.getDosis());
        entity.setFrecuencia(crearMedicamentoRecetadoDTO.getFrecuencia());
        entity.setIndicaciones(crearMedicamentoRecetadoDTO.getIndicaciones());
        entity.setDuracionDias(crearMedicamentoRecetadoDTO.getDuracionDias());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(MedicamentoRecetadoEntity entity, ActualizarMedicamentoRecetadoDTO dto) {
        Optional.ofNullable(dto.getMedicamentoId()).flatMap(medicamentoRepository::findById).
                ifPresent(entity::setMedicamentoEntity);
        entity.setDosis(dto.getDosis());
        entity.setFrecuencia(dto.getFrecuencia());
        entity.setIndicaciones(dto.getIndicaciones());
        entity.setDuracionDias(dto.getDuracionDias());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO) {
        return super.save(crearMedicamentoRecetadoDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarMedicamentoRecetadoDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}