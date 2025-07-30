package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.dtos.post.CrearAseguradoraDTO;
import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.Aseguradora;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;

public class AseguradoraCreateService {

    private final AseguradoraRepository aseguradoraRepository;

    public AseguradoraCreateService(AseguradoraRepository aseguradoraRepository) {
        this.aseguradoraRepository = aseguradoraRepository;
    }

    public Aseguradora execute(CrearAseguradoraDTO dto) {

        var aseguradoraToSave = AseguradoraMapper.fromCreateDto(dto);

        return aseguradoraRepository.save(aseguradoraToSave);

    }

}
