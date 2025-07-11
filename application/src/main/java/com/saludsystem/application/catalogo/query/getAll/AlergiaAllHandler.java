package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.AlergiaDTO;
import com.saludsystem.application.catalogo.mapper.AlergiaMapper;
import com.saludsystem.domain.catalogo.model.Alergia;
import com.saludsystem.domain.catalogo.port.in.service.AlergiaService;
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