package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoCreateService;
import org.springframework.stereotype.Component;

@Component
public class ApoderadoCreateHandler {

    private final ApoderadoCreateService apoderadoCreateService;
    private final ApoderadoMapper apoderadoMapper;

    public ApoderadoCreateHandler(ApoderadoCreateService apoderadoCreateService, ApoderadoMapper apoderadoMapper) {
        this.apoderadoCreateService = apoderadoCreateService;
        this.apoderadoMapper = apoderadoMapper;
    }

    public void execute(ApoderadoCreateCommand dto) {

        var apoderado = apoderadoMapper.fromCreateDto(dto);

        apoderadoCreateService.execute(apoderado);

    }

}