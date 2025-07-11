package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearAlergiaDTO;
import com.saludsystem.application.catalogo.mapper.AlergiaMapper;
import com.saludsystem.domain.catalogo.port.in.service.AlergiaService;
import org.springframework.stereotype.Component;

@Component
public class AlergiaCreateHandler {

    private final AlergiaService service;

    public AlergiaCreateHandler(AlergiaService service) {
        this.service = service;
    }

    public void execute(CrearAlergiaDTO dto) {
        service.save(AlergiaMapper.fromCreateDto(dto));
    }
}