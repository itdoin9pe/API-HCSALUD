package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.AlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.in.service.AlergiaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaByIdHandler {

    private final AlergiaService service;

    public AlergiaByIdHandler(AlergiaService service) {
        this.service = service;
    }

    public AlergiaDTO execute(UUID id) {
        Alergia model = service.getById(id);
        return AlergiaMapper.toDto(model);
    }
}