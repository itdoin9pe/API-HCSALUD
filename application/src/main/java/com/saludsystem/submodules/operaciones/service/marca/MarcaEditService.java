package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarMarcaDTO;
import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;

import java.util.UUID;

public class MarcaEditService {

    private final MarcaRepository marcaRepository;

    public MarcaEditService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca execute(UUID uuid, ActualizarMarcaDTO dto) {

        var marcaUpdated = MarcaMapper.fromUpdateDto(uuid, dto);

        return marcaRepository.update(uuid, marcaUpdated);

    }

}
