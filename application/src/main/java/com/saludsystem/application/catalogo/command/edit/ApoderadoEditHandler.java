package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.application.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.domain.catalogo.port.in.service.ApoderadoService;
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