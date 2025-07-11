package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.AlergiaDTO;
import com.saludsystem.application.catalogo.mapper.AlergiaMapper;
import com.saludsystem.domain.catalogo.model.Alergia;
import com.saludsystem.domain.catalogo.port.in.service.AlergiaService;
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