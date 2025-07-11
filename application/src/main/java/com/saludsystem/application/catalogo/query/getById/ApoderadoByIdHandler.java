package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.ApoderadoDTO;
import com.saludsystem.application.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.domain.catalogo.model.Apoderado;
import com.saludsystem.domain.catalogo.port.in.service.ApoderadoService;
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
