package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;

public class TarifarioCreateService {

    private final TarifarioRepository tarifarioRepository;

    public TarifarioCreateService(TarifarioRepository tarifarioRepository) {
        this.tarifarioRepository = tarifarioRepository;
    }

    public Tarifario execute(CrearTarifarioDTO dto) {

        var saved = TarifarioMapper.fromCreateDto(dto);

        return tarifarioRepository.save(saved);

    }

}
