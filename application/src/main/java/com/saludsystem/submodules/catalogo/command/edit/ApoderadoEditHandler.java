package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoEditHandler {

    private final ApoderadoDao service;

    public ApoderadoEditHandler(ApoderadoDao service) {
        this.service = service;
    }

    public void execute(UUID id, ActualizarApoderadoDTO dto) {
        service.update(id, ApoderadoMapper.fromUpdateDto(id, dto));
    }
}