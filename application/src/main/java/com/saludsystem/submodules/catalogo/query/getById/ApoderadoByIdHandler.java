package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.in.service.ApoderadoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoByIdHandler {

    private final ApoderadoService service;

    public ApoderadoByIdHandler(ApoderadoService service) {
        this.service = service;
    }

    public ApoderadoDTO execute(UUID id) {
        Apoderado model = service.getById(id);
        return ApoderadoMapper.toDto(model);
    }
}
