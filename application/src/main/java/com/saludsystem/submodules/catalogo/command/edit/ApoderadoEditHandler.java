package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.ApoderadoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoEditHandler {

    private final ApoderadoService service;

    public ApoderadoEditHandler(ApoderadoService service) {
        this.service = service;
    }

    public void execute(UUID id, ActualizarApoderadoDTO dto) {
        service.update(id, ApoderadoMapper.fromUpdateDto(id, dto));
    }
}