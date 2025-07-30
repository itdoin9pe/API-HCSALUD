package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.dtos.post.CrearPaisDTO;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;

public class PaisCreateService {

    private final PaisRepository paisRepository;

    public PaisCreateService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais execute(CrearPaisDTO dto) {

        var saved = PaisMapper.fromCreateDto(dto);

        return paisRepository.save(saved);

    }

}
