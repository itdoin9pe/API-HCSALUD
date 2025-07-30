package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.dtos.put.ActualizarEstudioDTO;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;

import java.util.UUID;

public class EstudioEditService {

    private final EstudioRepository estudioRepository;

    public EstudioEditService(EstudioRepository estudioRepository) {
        this.estudioRepository = estudioRepository;
    }

    public Estudio execute(UUID uuid, ActualizarEstudioDTO dto) {

        var updated = EstudioMapper.fromUpdateDto(uuid, dto);

        return estudioRepository.update(uuid, updated);

    }

}
