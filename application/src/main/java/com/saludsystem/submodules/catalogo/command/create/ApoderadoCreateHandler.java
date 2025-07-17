package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearApoderadoDTO;
import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import org.springframework.stereotype.Component;

@Component
public class ApoderadoCreateHandler {

    private final ApoderadoDao service;

    public ApoderadoCreateHandler(ApoderadoDao service) {
        this.service = service;
    }

    public void execute(CrearApoderadoDTO dto) {
        service.save(ApoderadoMapper.fromCreateDto(dto));
    }
}