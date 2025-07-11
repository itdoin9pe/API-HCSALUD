package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearApoderadoDTO;
import com.saludsystem.application.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.domain.catalogo.port.in.service.ApoderadoService;
import org.springframework.stereotype.Component;

@Component
public class ApoderadoCreateHandler {

    private final ApoderadoService service;

    public ApoderadoCreateHandler(ApoderadoService service) {
        this.service = service;
    }

    public void execute(CrearApoderadoDTO dto) {
        service.save(ApoderadoMapper.fromCreateDto(dto));
    }
}