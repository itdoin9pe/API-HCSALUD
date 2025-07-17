package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearAlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import org.springframework.stereotype.Component;

@Component
public class AlergiaCreateHandler {

    private final AlergiaDao service;

    public AlergiaCreateHandler(AlergiaDao service) {
        this.service = service;
    }

    public void execute(CrearAlergiaDTO dto) {
        service.save(AlergiaMapper.fromCreateDto(dto));
    }
}