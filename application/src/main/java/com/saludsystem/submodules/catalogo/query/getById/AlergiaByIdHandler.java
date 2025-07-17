package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaByIdHandler {

    private final AlergiaDao service;

    public AlergiaByIdHandler(AlergiaDao service) {
        this.service = service;
    }

    public AlergiaDTO execute(UUID id) {
        Alergia model = service.getById(id);
        return AlergiaMapper.toDto(model);
    }
}