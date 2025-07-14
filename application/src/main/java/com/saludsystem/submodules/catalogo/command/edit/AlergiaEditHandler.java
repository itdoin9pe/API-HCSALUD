package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dtos.put.ActualizarAlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.port.in.service.AlergiaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaEditHandler {

    private final AlergiaService service;

    public AlergiaEditHandler(AlergiaService service) {
        this.service = service;
    }

    public void execute(UUID id, ActualizarAlergiaDTO dto) {
        service.update(id, AlergiaMapper.fromUpdateDto(id, dto));
    }
}
