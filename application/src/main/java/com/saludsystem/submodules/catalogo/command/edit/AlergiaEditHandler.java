package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarAlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaEditHandler {

    private final AlergiaDao service;

    public AlergiaEditHandler(AlergiaDao service) {
        this.service = service;
    }

    public void execute(UUID id, ActualizarAlergiaDTO dto) {
        service.update(id, AlergiaMapper.fromUpdateDto(id, dto));
    }
}
