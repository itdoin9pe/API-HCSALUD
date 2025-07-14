package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.ApoderadoService;
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