package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.Pais;
import com.saludsystem.submodules.principal.dtos.put.ActualizarPaisDTO;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;

public class PaisEditService {

    private final PaisRepository paisRepository;

    public PaisEditService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais execute(Integer id, ActualizarPaisDTO dto) {

        var updated = PaisMapper.fromUpdateDto(id, dto);

        return paisRepository.update(id, updated);

    }

}
