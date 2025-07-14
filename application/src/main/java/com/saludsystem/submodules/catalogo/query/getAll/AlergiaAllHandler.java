package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.AlergiaDTO;
import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.port.in.service.AlergiaService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AlergiaAllHandler {

    private final AlergiaService service;

    public AlergiaAllHandler(AlergiaService service) {
        this.service = service;
    }

    public List<AlergiaDTO> execute(UUID hospitalId, int page, int rows) {
        List<Alergia> models = service.getAll(hospitalId, page, rows);
        return models.stream()
                .map(AlergiaMapper::toDto)
                .toList();
    }
}