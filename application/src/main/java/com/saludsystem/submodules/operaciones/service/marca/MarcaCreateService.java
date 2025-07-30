package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.dtos.command.CrearMarcaDTO;
import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.Marca;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;

public class MarcaCreateService {

    private final MarcaRepository marcaRepository;

    public MarcaCreateService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca execute(CrearMarcaDTO dto) {

        var marcaSaved = MarcaMapper.fronCreateDto(dto);

        return marcaRepository.save(marcaSaved);

    }

}
