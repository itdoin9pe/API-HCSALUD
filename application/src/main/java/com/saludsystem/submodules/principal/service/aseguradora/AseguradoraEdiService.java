package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.model.dtos.put.ActualizarAseguradoraDTO;
import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;

import java.util.UUID;

public class AseguradoraEdiService {

    private final AseguradoraRepository aseguradoraRepository;

    public AseguradoraEdiService(AseguradoraRepository aseguradoraRepository) {
        this.aseguradoraRepository = aseguradoraRepository;
    }

    public Aseguradora execute(UUID uuid, ActualizarAseguradoraDTO dto) {
        var updated = AseguradoraMapper.fromUpdateDto(uuid, dto);
        return aseguradoraRepository.update(uuid, updated);
    }

}
