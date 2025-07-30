package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.Estudio;
import com.saludsystem.submodules.principal.dtos.post.CrearEstudioDTO;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;

public class EstudioCreateService {

    private final EstudioRepository estudioRepository;

    public EstudioCreateService(EstudioRepository estudioRepository) {
        this.estudioRepository = estudioRepository;
    }

    public Estudio execute(CrearEstudioDTO dto) {

        var estudioToSave = EstudioMapper.fromCreateDto(dto);

        return estudioRepository.save(estudioToSave);

    }

}
