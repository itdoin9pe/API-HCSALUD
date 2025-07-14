package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearAlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.port.in.service.AlergiaService;
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