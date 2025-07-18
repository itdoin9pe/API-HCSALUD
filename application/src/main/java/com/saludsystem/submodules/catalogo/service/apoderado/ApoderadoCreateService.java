package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.model.dto.command.CrearApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;

public class ApoderadoCreateService {

    private final ApoderadoRepository apoderadoRepository;

    public ApoderadoCreateService(ApoderadoRepository apoderadoRepository) {
        this.apoderadoRepository = apoderadoRepository;
    }

    public Apoderado execute(CrearApoderadoDTO dto){
        var apoderadoToCreate = ApoderadoMapper.fromCreateDto(dto);
        return apoderadoRepository.save(apoderadoToCreate);
    }
}
