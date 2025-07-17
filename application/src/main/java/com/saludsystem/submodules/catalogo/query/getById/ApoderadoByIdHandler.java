package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.Apoderado;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoByIdHandler {

    private final ApoderadoDao service;

    public ApoderadoByIdHandler(ApoderadoDao service) {
        this.service = service;
    }

    public ApoderadoDTO execute(UUID id) {
        Apoderado model = service.getById(id);
        return ApoderadoMapper.toDto(model);
    }
}
